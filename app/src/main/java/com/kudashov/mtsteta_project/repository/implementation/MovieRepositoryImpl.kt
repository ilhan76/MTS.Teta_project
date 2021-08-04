package com.kudashov.mtsteta_project.repository.implementation

import android.util.Log
import com.kudashov.mtsteta_project.data.converter.MovieConverter
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
    private val movieProvider: MovieProvider,
    private val converter: MovieConverter
) : MovieRepository {
    private val TAG: String = this::class.java.simpleName

    override suspend fun getGenreListAsync(): Deferred<GenreListResponse> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getGenreListAsync: Repo")
                val genres = movieProvider.getGenreListAsync().await()

                val listGenres = genres.list?.map { converter.convertGenreListFromApiToDomain(it) }

                GenreListResponse(listGenres, genres.detail)
            } catch (e: Exception) {
                GenreListResponse(null, e.localizedMessage)
            }
        }


    override suspend fun getMovieListAsync(): Deferred<MovieListResponse> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getMovieListAsync: Repo")
                val movies = movieProvider.getMovieListAsync().await()

                val listMovie = movies.list?.map { converter.convertMovieListFromApiToDomain(it) }

                MovieListResponse(listMovie, movies.detail)
            } catch (e: Exception) {
                MovieListResponse(
                    null, e.localizedMessage
                )
            }
        }


    override suspend fun getMovieMoreInfAsync(id: Int): Deferred<MovieMoreInfResponse> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getMovieMoreInfAsync: Repo")
                val movie = movieProvider.getMovieMoreInfAsync(id).await()

                movie
            } catch (e: Exception) {
                MovieMoreInfResponse(null, e.localizedMessage)
            }
        }

}