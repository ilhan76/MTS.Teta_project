package com.kudashov.mtsteta_project.net.response.movieList

import com.google.gson.annotations.SerializedName
import com.kudashov.mtsteta_project.data.dto.GenreDto

data class GenreListResponse (
    @SerializedName("genres")
    val list: List<GenreDto>?,
    val detail: String?
)