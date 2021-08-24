package com.kudashov.mtsteta_project.net.response.movieDetail

import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto

data class MovieMoreInfResponse (
    val movie: MovieMoreInfDto?,
    val detail: String?
)