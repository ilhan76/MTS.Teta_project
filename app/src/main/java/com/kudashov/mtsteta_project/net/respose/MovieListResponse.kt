package com.kudashov.mtsteta_project.net.respose

import com.kudashov.mtsteta_project.data.dto.MovieDto

data class MovieListResponse(
    val list: List<MovieDto>,
    val detail: String
)