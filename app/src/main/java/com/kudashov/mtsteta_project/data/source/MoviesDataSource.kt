package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.dto.MovieDto

interface MoviesDataSource {
    fun getMovies(): List<MovieDto>
}