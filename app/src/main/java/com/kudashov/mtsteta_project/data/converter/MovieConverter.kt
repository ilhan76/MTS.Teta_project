package com.kudashov.mtsteta_project.data.converter

import com.kudashov.mtsteta_project.data.dto.Genre
import com.kudashov.mtsteta_project.data.dto.MovieDto

interface MovieConverter {
    fun convertMovieListFromApiToDomain(movie: MovieDto) : MovieDto
    fun convertGenreListFromApiToDomain(genre: Genre) : Genre
}