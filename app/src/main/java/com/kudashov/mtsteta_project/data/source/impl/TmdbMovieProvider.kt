package com.kudashov.mtsteta_project.data.source.impl

import android.util.Log
import com.kudashov.mtsteta_project.App
import com.kudashov.mtsteta_project.data.source.RemoteMovieProvider
import com.kudashov.mtsteta_project.net.response.movieList.GenreListResponse
import com.kudashov.mtsteta_project.net.response.movieList.MovieListResponse
import com.kudashov.mtsteta_project.net.response.movieDetail.MovieMoreInfResponse
import com.kudashov.mtsteta_project.net.response.movieList.AgeRestrictionResponse
import com.kudashov.mtsteta_project.util.API_KEY
import com.kudashov.mtsteta_project.util.LANGUAGE_RU
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
                return@async App.instance.apiService.getMovies(API_KEY, LANGUAGE_RU)
            } catch (e: Exception) {
                Log.d(TAG, "getMovieListAsync: ${e.localizedMessage}")
                return@async MovieListResponse(null, e.localizedMessage)
            }
        }

    override suspend fun getAgeRestrictionAsync(id: Int): Deferred<AgeRestrictionResponse> =
        GlobalScope.async(Dispatchers.IO) {
            try {
                Log.d(TAG, "getAgeRestrictionAsync: TMDB")
                return@async App.instance.apiService.getAgeRestriction(id, API_KEY, LANGUAGE_RU)
            } catch (e: Exception) {
                Log.d(TAG, "getAgeRestrictionAsync: ${e.localizedMessage}")
                return@async AgeRestrictionResponse(null)
            }
        }

    override suspend fun getGenreListAsync(): Deferred<GenreListResponse> =
        GlobalScope.async(Dispatchers.IO) {
            try {
                Log.d(TAG, "getGenreListAsync: TMDB")
                return@async App.instance.apiService.getGenres(API_KEY, LANGUAGE_RU)
            } catch (e: Exception) {
                Log.d(TAG, "getGenreListAsync: ${e.localizedMessage}")
                return@async GenreListResponse(null, e.localizedMessage)
            }
        }

    override suspend fun getMovieMoreInfAsync(id: Int): Deferred<MovieMoreInfResponse> =
        GlobalScope.async(Dispatchers.IO) {
            try {
                App.instance.apiService.getMovieMoreInf(id, API_KEY, LANGUAGE_RU)
            } catch (e: Exception){
                MovieMoreInfResponse(null, e.localizedMessage)
            }
        }
}