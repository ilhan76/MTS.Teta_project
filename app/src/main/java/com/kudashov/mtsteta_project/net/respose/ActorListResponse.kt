package com.kudashov.mtsteta_project.net.respose

import com.kudashov.mtsteta_project.data.dto.Actor

data class ActorListResponse (
    val list: List<Actor>,
    val detail: String
)