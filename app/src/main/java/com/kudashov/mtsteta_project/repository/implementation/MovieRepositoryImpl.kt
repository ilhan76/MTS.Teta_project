package com.kudashov.mtsteta_project.repository.implementation

import android.util.Log
import com.kudashov.mtsteta_project.data.converter.MovieConverter
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.source.LocalMovieProvider
import com.kudashov.mtsteta_project.data.source.RemoteMovieProvider
import com.kudashov.mtsteta_project.net.response.*
import com.kudashov.mtsteta_project.repository.MovieRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MovieRepositoryImpl(
    private val localMovieProvider: LocalMovieProvider,
    private val remoteMovieProvider: RemoteMovieProvider,
    private val converter: MovieConverter
) : MovieRepository {
    private val TAG: String = this::class.java.simpleName

    override suspend fun getGenreListAsync(): Deferred<RepoResponse<List<GenreDomain>>> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getGenreListAsync: Repo")
                val genres = remoteMovieProvider.getGenreListAsync().await()

                val listGenres = genres.list?.map { converter.convertGenreListFromApiToDomain(it) }

                RepoResponse(listGenres, genres.detail)
            } catch (e: Exception) {
                RepoResponse<List<GenreDomain>>(null, e.localizedMessage)
            }
        }

    override fun getMovieList(): Flow<RepoResponse<List<MovieDomain>>> = flow {
        Log.d(TAG, "getMovieListAsync: Repo")

        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieListAsync: LOCAL")
                val movies = localMovieProvider.getMovieListAsync().await()
                val listMovie = movies.map { converter.convertMovieListFromEntityToDomain(it) }
                RepoResponse(listMovie, null)
            } catch (e: Exception) {
                RepoResponse<List<MovieDomain>>(null, e.localizedMessage)
            }
        })
        emit(withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "getMovieListAsync: REMOTE")
                val movies = remoteMovieProvider.getMovieListAsync().await()
                val listMovie = movies.list?.map {
                    converter.convertMovieListFromApiToDomain(it)
                }

                localMovieProvider.addMovies(movies.list?.map {
                    converter.convertMovieListFromDtoToEntity(it)
                }!!)

                RepoResponse(listMovie, null)
            } catch (e: Exception) {
                RepoResponse<List<MovieDomain>>(null, e.localizedMessage)
            }
        })
    }

    override suspend fun getMovieMoreInfAsync(id: Int): Deferred<RepoResponse<MovieMoreInfDomain>> =
        GlobalScope.async {
            try {
                Log.d(TAG, "getMovieMoreInfAsync: Repo")
                val movieResponse = remoteMovieProvider.getMovieMoreInfAsync(id).await()

                if (movieResponse.movie != null) {
                    val movie = converter.convertMovieMoreInfFromApiToDomain(movieResponse.movie)
                    RepoResponse(movie, movieResponse.detail)
                } else RepoResponse<MovieMoreInfDomain>(null, movieResponse.detail)
            } catch (e: Exception) {
                RepoResponse<MovieMoreInfDomain>(null, e.localizedMessage)
            }
        }

}