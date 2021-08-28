package com.kudashov.mtsteta_project.data.dto

import com.google.gson.annotations.SerializedName

data class ActorDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("profile_path")
    val avatarUrl: String?
)