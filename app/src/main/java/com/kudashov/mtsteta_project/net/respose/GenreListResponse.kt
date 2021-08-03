package com.kudashov.mtsteta_project.net.respose

import com.kudashov.mtsteta_project.data.dto.Genre

data class GenreListResponse (
    val list: List<Genre>?,
    val detail: String
)