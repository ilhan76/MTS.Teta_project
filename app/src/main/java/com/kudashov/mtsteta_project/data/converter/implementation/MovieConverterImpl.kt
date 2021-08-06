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

    override fun convertGenreListFromApiToDomain(genreDto: GenreDto): GenreDomain {
        return GenreDomain(
            genreDto.id,
            genreDto.genre
        )
    }

    override fun convertMovieMoreInfFromApiToDomain(movieMoreInfDto: MovieMoreInfDto): MovieMoreInfDomain {
        return MovieMoreInfDomain(
            movieMoreInfDto.id,
            movieMoreInfDto.imageUrl,
            convertGenreListFromApiToDomain(movieMoreInfDto.genre),
            movieMoreInfDto.data,
            movieMoreInfDto.ageRestriction,
            movieMoreInfDto.title,
            movieMoreInfDto.description,
            movieMoreInfDto.rateScore,
            convertActorsFromApiToDomain(movieMoreInfDto.actors)
        )
    }

    private fun convertActorsFromApiToDomain(actorsDto: List<ActorDto>): List<ActorDomain>{
        return actorsDto.map {
            ActorDomain(
                it.name,
                it.avatarUrl
            )
        }
    }
}