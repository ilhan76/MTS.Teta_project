package com.kudashov.mtsteta_project.net.response.movieList

import com.google.gson.annotations.SerializedName

data class AgeRestrictionResponse(
    @SerializedName("results")
    val list: List<ItemAgeRestrictionResponse>?
)

data class ItemAgeRestrictionResponse(
    @SerializedName("iso_3166_1")
    val lang: String,
    @SerializedName("release_dates")
    val list: List<AgeRestriction>
)

data class AgeRestriction(
    @SerializedName("certification")
    val restriction: String
)