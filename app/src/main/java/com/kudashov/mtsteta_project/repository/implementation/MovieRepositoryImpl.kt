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

    override suspend fun getGenreListAsync(): Deferred<GenreListResponse> {
        try {
            return GlobalScope.async {
                Log.d(TAG, "getGenreListAsync: Repo")
                val genres = movieProvider.getGenreListAsync().await()
                Log.d(TAG, "getGenreListAsync: genres.list")

                val listGenres = genres.list?.map {
                    converter.convertGenreListFromApiToDomain(it)
                }
                GenreListResponse(listGenres, "")
            }
        } catch (e: Exception) {
            return GlobalScope.async {
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

                val listMovie = movies.list?.map {
                    converter.convertMovieListFromApiToDomain(it)
                }
                MovieListResponse(listMovie, "")
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