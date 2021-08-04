package com.kudashov.mtsteta_project.repository.implementation

import android.util.Log
import com.kudashov.mtsteta_project.data.converter.MovieConverter
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.source.MovieProvider
import com.kudashov.mtsteta_project.net.respose.*
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

    override suspend fun getGenreListAsync(): Deferred<RepoResponse<List<GenreDomain>>> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getGenreListAsync: Repo")
                Thread.sleep(2)
                val genres = movieProvider.getGenreListAsync().await()

                val listGenres = genres.list?.map { converter.convertGenreListFromApiToDomain(it) }

                RepoResponse(listGenres, genres.detail)
            } catch (e: Exception) {
                RepoResponse<List<GenreDomain>>(null, e.localizedMessage)
            }
        }

    override suspend fun getMovieListAsync(): Deferred<RepoResponse<List<MovieDomain>>> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getMovieListAsync: Repo")
                Thread.sleep(2)
                val movies = movieProvider.getMovieListAsync().await()

                val listMovie = movies.list?.map { converter.convertMovieListFromApiToDomain(it) }

                RepoResponse(listMovie, movies.detail)
            } catch (e: Exception) {
                RepoResponse<List<MovieDomain>>(
                    null, e.localizedMessage
                )
            }
        }


    override suspend fun getMovieMoreInfAsync(id: Int): Deferred<RepoResponse<MovieMoreInfDomain>> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getMovieMoreInfAsync: Repo")
                Thread.sleep(2)
                val movieResponse = movieProvider.getMovieMoreInfAsync(id).await()

                if (movieResponse.movie != null) {
                    val movie = converter.convertMovieMoreInfFromApiToDomain(movieResponse.movie)
                    RepoResponse(movie, movieResponse.detail)
                } else RepoResponse<MovieMoreInfDomain>(null, movieResponse.detail)
            } catch (e: Exception) {
                RepoResponse<MovieMoreInfDomain>(null, e.localizedMessage)
            }
        }

}