package com.kudashov.mtsteta_project.net.respose

import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto

data class MovieMoreInfResponse (
    val movie: MovieMoreInfDto?,
    val detail: String?
)