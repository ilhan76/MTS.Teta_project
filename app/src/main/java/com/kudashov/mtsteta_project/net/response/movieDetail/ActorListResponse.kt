package com.kudashov.mtsteta_project.net.response.movieDetail

import com.google.gson.annotations.SerializedName
import com.kudashov.mtsteta_project.data.dto.ActorDto

data class ActorListResponse(
    @SerializedName("cast")
    val list: List<ActorDto>?,
    val detail: String?
)