package com.kudashov.mtsteta_project.net.response.movieDetail

import com.google.gson.annotations.SerializedName
import com.kudashov.mtsteta_project.data.dto.GenreDto

data class MovieMoreInfResponse (
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("backdrop_path")
    val imageUrl: String? = null,
    @SerializedName("genres")
    val genre: List<GenreDto>? = null,
    @SerializedName("release_date")
    val date: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val description: String? = null,
    @SerializedName("vote_average")
    val rateScore: Double? = null,
    val detail: String?
)