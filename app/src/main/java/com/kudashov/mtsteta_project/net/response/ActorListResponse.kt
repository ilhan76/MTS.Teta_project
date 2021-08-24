package com.kudashov.mtsteta_project.net.response

import com.kudashov.mtsteta_project.data.dto.ActorDto

data class ActorListResponse(
    val list: List<ActorDto>?,
    val detail: String?
)