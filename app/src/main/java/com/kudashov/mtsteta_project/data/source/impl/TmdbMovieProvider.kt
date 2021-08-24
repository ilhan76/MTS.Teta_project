package com.kudashov.mtsteta_project.data.source.impl

import android.util.Log
import com.kudashov.mtsteta_project.App
import com.kudashov.mtsteta_project.data.source.RemoteMovieProvider
import com.kudashov.mtsteta_project.net.response.GenreListResponse
import com.kudashov.mtsteta_project.net.response.MovieListResponse
import com.kudashov.mtsteta_project.net.response.MovieMoreInfResponse
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.lang.Exception

class TmdbMovieProvider : RemoteMovieProvider {
    private val TAG: String = this::class.java.simpleName

    override suspend fun getMovieListAsync(): Deferred<MovieListResponse> =
        GlobalScope.async(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieListAsync: TMDB")
                val resp = App.instance.apiService.getMovies(
                    "9d436a04889597a4869e5b2e91511a8b",
                    "ru-RU"
                )
                return@async resp
            } catch (e: Exception) {
                Log.d(TAG, "getMovieListAsync: ${e.localizedMessage}")
                return@async MovieListResponse(null, e.localizedMessage)
            }
        }

    override suspend fun getGenreListAsync(): Deferred<GenreListResponse> =
        GlobalScope.async(Dispatchers.IO) {
            try {
                Log.d(TAG, "getGenreListAsync: TMDB")
                val resp = App.instance.apiService.getGenres(
                    "9d436a04889597a4869e5b2e91511a8b",
                    "ru-RU"
                )
                return@async resp
            } catch (e: Exception) {
                Log.d(TAG, "getMovieListAsync: ${e.localizedMessage}")
                return@async GenreListResponse(null, e.localizedMessage)
            }
        }

    override suspend fun getMovieMoreInfAsync(id: Int): Deferred<MovieMoreInfResponse> {
        TODO("Not yet implemented")
    }
}