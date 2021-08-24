package com.kudashov.mtsteta_project.net.response

import com.google.gson.annotations.SerializedName
import com.kudashov.mtsteta_project.data.dto.MovieDto

data class MovieListResponse(
    @SerializedName("results")
    val list: List<MovieDto>?,
    val detail: String?
)