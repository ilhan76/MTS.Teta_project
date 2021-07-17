package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.dto.Genre

interface GenreDataSource{
    fun getGenre(): List<Genre>
}