package com.kudashov.mtsteta_project.adapters.delegates

import com.kudashov.mtsteta_project.data.dto.Genre

interface GenresDelegate {
    fun onGenreClick(genre: Genre)
}