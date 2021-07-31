package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto

interface MovieMoreInfSource {
    fun getMovieMoreInfo(id: Int): MovieMoreInfDto
}