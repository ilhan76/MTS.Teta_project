package com.kudashov.mtsteta_project.adapters.delegates

import com.kudashov.mtsteta_project.data.domain.GenreDomain

interface GenresDelegate {
    fun onGenreClick(genre: GenreDomain)
}