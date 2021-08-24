package com.kudashov.mtsteta_project.repository

import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.net.response.RepoResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getGenreList() : Flow<RepoResponse<List<GenreDomain>>>
    fun getMovieList() : Flow<RepoResponse<List<MovieDomain>>>
    fun getMovieMoreInf(id: Int) : Flow<RepoResponse<MovieMoreInfDomain>>
}