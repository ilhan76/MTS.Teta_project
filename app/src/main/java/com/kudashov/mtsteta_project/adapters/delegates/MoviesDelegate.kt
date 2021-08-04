package com.kudashov.mtsteta_project.adapters.delegates

import com.kudashov.mtsteta_project.data.domain.MovieDomain

interface MoviesDelegate {
    fun onMovieItemClick(movie: MovieDomain)
}