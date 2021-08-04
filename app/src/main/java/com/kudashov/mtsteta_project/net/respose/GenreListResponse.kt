package com.kudashov.mtsteta_project.net.respose

import com.kudashov.mtsteta_project.data.dto.GenreDto

data class GenreListResponse (
    val list: List<GenreDto>?,
    val detail: String?
)