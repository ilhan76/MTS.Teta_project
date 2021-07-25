package com.kudashov.mtsteta_project.adapters.delegates

import com.kudashov.mtsteta_project.data.dto.MovieDto

interface MoviesDelegate {
    fun onMovieItemClick(movie: MovieDto)
}