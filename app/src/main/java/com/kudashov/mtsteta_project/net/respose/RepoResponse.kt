package com.kudashov.mtsteta_project.net.respose

data class RepoResponse<T>(
    val content: T?,
    val detail: String?
)