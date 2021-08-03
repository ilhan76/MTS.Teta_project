package com.kudashov.mtsteta_project.repository.implementation

import android.util.Log
import com.kudashov.mtsteta_project.data.source.MovieProvider
import com.kudashov.mtsteta_project.net.respose.ActorListResponse
import com.kudashov.mtsteta_project.net.respose.GenreListResponse
import com.kudashov.mtsteta_project.net.respose.MovieListResponse
import com.kudashov.mtsteta_project.net.respose.MovieMoreInfResponse
import com.kudashov.mtsteta_project.repository.MovieRepository
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieProvider: MovieProvider
) : MovieRepository {
    private val TAG: String = this::class.java.simpleName

    override suspend fun getGenreListAsync(): Deferred<GenreListResponse> {
        return try {
            GlobalScope.async {
                Log.d(TAG, "getGenreListAsync: Repo")
                val genres = movieProvider.getGenreListAsync().await()
                // конвертим дто с сервера
                Log.d(TAG, "getGenreListAsync: genres.list")
                genres
            }
        } catch (e: Exception) {
            GlobalScope.async {
                error(e)
            }
        }
    }

    override suspend fun getMovieListAsync(): Deferred<MovieListResponse> {
        return try {
            GlobalScope.async {
                Log.d(TAG, "getMovieListAsync: Repo")
                val movies = movieProvider.getMovieListAsync().await()
                Log.d(TAG, "getMovieListAsync: movie.list")
                movies
            }
        } catch (e: Exception) {
            error(e)
        }
    }

    override suspend fun getMovieMoreInfAsync(): Deferred<MovieMoreInfResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getActorsAsync(): Deferred<ActorListResponse> {
        TODO("Not yet implemented")
    }
}