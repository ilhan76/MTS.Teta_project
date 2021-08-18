package com.kudashov.mtsteta_project.data.converter.implementation

import androidx.room.ColumnInfo
import com.kudashov.mtsteta_project.data.converter.MovieConverter
import com.kudashov.mtsteta_project.data.domain.ActorDomain
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.dto.GenreDto
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.dto.ActorDto
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto
import com.kudashov.mtsteta_project.data.room.entity.ActorEntity
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieMoreInfEntity

class MovieConverterImpl : MovieConverter {

    override fun convertMovieListFromApiToDomain(movieDto: MovieDto): MovieDomain {
        return MovieDomain(
            movieDto.id,
            movieDto.title,
            movieDto.description,
            movieDto.rateScore,
            movieDto.ageRestriction,
            movieDto.imageUrl
        )
    }

    override fun convertMovieListFromEntityToDomain(movieEntity: MovieEntity): MovieDomain =
        MovieDomain(
            id = movieEntity.id,
            title = movieEntity.title,
            imageUrl = movieEntity.imageUrl,
            ageRestriction = movieEntity.ageRestriction,
            description = movieEntity.description,
            rateScore = movieEntity.rateScore
        )

    override fun convertMovieListFromDtoToEntity(movieDto: MovieDto): MovieEntity = MovieEntity(
        id = movieDto.id,
        title = movieDto.title,
        imageUrl = movieDto.imageUrl,
        date = movieDto.date,
        ageRestriction = movieDto.ageRestriction,
        description = movieDto.description,
        rateScore = movieDto.rateScore
    )

    override fun convertGenreListFromApiToDomain(genreDto: GenreDto): GenreDomain =
        GenreDomain(
            genreDto.id,
            genreDto.genre
        )


    override fun convertGenreListFromEntityToDomain(genreEntity: GenreEntity): GenreDomain =
        GenreDomain(
            id = genreEntity.id,
            genre = genreEntity.genre
        )

    override fun convertGenreListFromDtoToEntity(genreDto: GenreDto): GenreEntity = GenreEntity(
        id = genreDto.id,
        genre = genreDto.genre
    )

    override fun convertMovieMoreInfFromApiToDomain(movieMoreInfDto: MovieMoreInfDto): MovieMoreInfDomain {
        return MovieMoreInfDomain(
            movieMoreInfDto.id,
            movieMoreInfDto.imageUrl,
            movieMoreInfDto.genre.map {
                convertGenreListFromApiToDomain(it)
            },
            movieMoreInfDto.date,
            movieMoreInfDto.ageRestriction,
            movieMoreInfDto.title,
            movieMoreInfDto.description,
            movieMoreInfDto.rateScore,
            convertActorsFromApiToDomain(movieMoreInfDto.actors)
        )
    }

    override fun convertMovieMoreInfFromEntityToDomain(movieMoreInfEntity: MovieMoreInfEntity): MovieMoreInfDomain =
        MovieMoreInfDomain(
            id = movieMoreInfEntity.movieEntity.id,
            imageUrl = movieMoreInfEntity.movieEntity.imageUrl,
            genre = movieMoreInfEntity.genres.map {
                convertGenreListFromEntityToDomain(it)
            },
            data = movieMoreInfEntity.movieEntity.date,
            ageRestriction = movieMoreInfEntity.movieEntity.ageRestriction,
            title = movieMoreInfEntity.movieEntity.title,
            description = movieMoreInfEntity.movieEntity.description,
            rateScore = movieMoreInfEntity.movieEntity.rateScore,
            actors = movieMoreInfEntity.actors.map {
                convertActorFromEntityToDomain(it)
            }
        )

    override fun convertMovieMoreInfFromDtoToEntity(movieMoreInfDto: MovieMoreInfDto): MovieMoreInfEntity =
        MovieMoreInfEntity(
            movieEntity = MovieEntity(
                id = movieMoreInfDto.id,
                title = movieMoreInfDto.title,
                imageUrl = movieMoreInfDto.imageUrl,
                date = movieMoreInfDto.date,
                ageRestriction = movieMoreInfDto.ageRestriction,
                description = movieMoreInfDto.description,
                rateScore = movieMoreInfDto.rateScore
            ),
            genres = movieMoreInfDto.genre.map {
                convertGenreListFromDtoToEntity(it)
            },
            actors = movieMoreInfDto.actors.map {
                convertActorFromApiToEntity(it)
            }
        )

    private fun convertActorsFromApiToDomain(actorsDto: List<ActorDto>): List<ActorDomain> =
        actorsDto.map {
            ActorDomain(
                it.id,
                it.name,
                it.avatarUrl
            )
        }

    private fun convertActorFromApiToEntity(actorsDto: ActorDto): ActorEntity = ActorEntity(
        actorsDto.id,
        actorsDto.name,
        actorsDto.avatarUrl
    )

    private fun convertActorFromEntityToDomain(actorEntity: ActorEntity): ActorDomain = ActorDomain(
        actorEntity.id,
        actorEntity.name,
        actorEntity.avatarUrl
    )
}