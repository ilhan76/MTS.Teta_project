package com.kudashov.mtsteta_project.data.converter.implementation

import com.kudashov.mtsteta_project.data.converter.MovieConverter
import com.kudashov.mtsteta_project.data.domain.ActorDomain
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.dto.GenreDto
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.dto.ActorDto
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity

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

    override fun convertMovieListFromEntityToDomain(movieEntity: MovieEntity): MovieDomain = MovieDomain(
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

    override fun convertGenreListFromApiToDomain(genreDto: GenreDto): GenreDomain {
        return GenreDomain(
            genreDto.id,
            genreDto.genre
        )
    }

    override fun convertGenreListFromEntityToDomain(genreEntity: GenreEntity): GenreDomain = GenreDomain(
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
            convertGenreListFromApiToDomain(movieMoreInfDto.genre),
            movieMoreInfDto.date,
            movieMoreInfDto.ageRestriction,
            movieMoreInfDto.title,
            movieMoreInfDto.description,
            movieMoreInfDto.rateScore,
            convertActorsFromApiToDomain(movieMoreInfDto.actors)
        )
    }

    override fun convertMovieMoreInfFromEntityToDomain(movieMoreInfDto: MovieMoreInfDto): MovieMoreInfDomain {
        TODO("Not yet implemented")
    }

    private fun convertActorsFromApiToDomain(actorsDto: List<ActorDto>): List<ActorDomain> {
        return actorsDto.map {
            ActorDomain(
                it.name,
                it.avatarUrl
            )
        }
    }
}