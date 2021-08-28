package com.kudashov.mtsteta_project.net.response.movieList

import com.google.gson.annotations.SerializedName

data class AgeRestrictionResponse(
    @SerializedName("results")
    val results: List<ItemAgeRestrictionResponse>?
)

data class ItemAgeRestrictionResponse(
    @SerializedName("iso_3166_1")
    val iso: String,
    @SerializedName("release_dates")
    val releaseDates: List<AgeRestriction>
)

data class AgeRestriction(
    @SerializedName("certification")
    val certification: String
)