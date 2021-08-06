package com.kudashov.mtsteta_project.net.response

data class RepoResponse<T>(
    val content: T?,
    val detail: String?
)