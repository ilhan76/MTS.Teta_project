package com.kudashov.mtsteta_project.repository

import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.net.response.RepoResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun getGenreListAsync() : Deferred<RepoResponse<List<GenreDomain>>>
    fun getMovieListAsync() : Flow<RepoResponse<List<MovieDomain>>>
    suspend fun getMovieMoreInfAsync(id: Int) : Deferred<RepoResponse<MovieMoreInfDomain>>
}