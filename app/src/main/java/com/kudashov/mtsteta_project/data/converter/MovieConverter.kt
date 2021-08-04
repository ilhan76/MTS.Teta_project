package com.kudashov.mtsteta_project.data.converter

import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.dto.GenreDto
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto

interface MovieConverter {
    fun convertMovieListFromApiToDomain(movieDto: MovieDto) : MovieDomain
    fun convertGenreListFromApiToDomain(genreDto: GenreDto) : GenreDomain
    fun convertMovieMoreInfFromApiToDomain(movieMoreInfDto: MovieMoreInfDto) : MovieMoreInfDomain
}