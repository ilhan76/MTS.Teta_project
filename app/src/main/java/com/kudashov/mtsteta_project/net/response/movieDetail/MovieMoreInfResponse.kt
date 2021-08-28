package com.kudashov.mtsteta_project.net.response.movieDetail

import com.google.gson.annotations.SerializedName
import com.kudashov.mtsteta_project.data.dto.GenreDto

data class MovieMoreInfResponse (
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,
    @SerializedName("genres")
    val genres: List<GenreDto>? = null,
    @SerializedName("release_date")
    val releaseDate: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("vote_average")
    val voteAverage: Double? = null,
    val detail: String?
)