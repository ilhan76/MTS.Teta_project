package com.kudashov.mtsteta_project.data.dto

import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val description: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("vote_average")
    val rateScore: Double,
    //val ageRestriction: Int,
    @SerializedName("poster_path")
    val imageUrl: String
)
