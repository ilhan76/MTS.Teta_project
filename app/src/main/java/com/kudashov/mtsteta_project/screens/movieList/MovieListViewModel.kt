package com.kudashov.mtsteta_project.screens.movieList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.room.AppDatabase
import com.kudashov.mtsteta_project.data.source.impl.RemoteMovieProviderImpl
import com.kudashov.mtsteta_project.data.source.impl.RoomMovieProvider
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryImpl
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

class MovieListViewModel(val context: Application) : AndroidViewModel(context) {
    private val TAG: String = this::class.java.simpleName
    private val repository: MovieRepository = MovieRepositoryImpl(
        localMovieProvider = RoomMovieProvider(AppDatabase.getInstance(getApplication())),
        remoteMovieProvider = RemoteMovieProviderImpl()
    )

    private val _genresLiveData = MutableLiveData<List<GenreDomain>>()
    val genresLiveData: LiveData<List<GenreDomain>> = _genresLiveData

    private val _moviesLiveData = MutableLiveData<List<MovieDomain>>()
    val moviesLiveData: LiveData<List<MovieDomain>> = _moviesLiveData

    fun getGenres() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Log.d(TAG, "getGenres: GENRES")
                repository.getGenreList()
                    .onEach {
                        if (it.content != null){
                            Log.d(TAG, "getGenres: ${it.content}")
                            withContext(Dispatchers.Main){
                                _genresLiveData.postValue(it.content)
                            }
                        } else {
                            when(it.detail){
                                "empty" -> Log.d(TAG, "getGenres: empty")
                            }
                            Log.d(TAG, "getGenres: Error ${it.detail}")
                        }
                    }.collect()
            }
        }
    }

    fun getMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getMovieList()
                    .onEach {
                        if (it.content != null) {
                            withContext(Dispatchers.Main) {
                                _moviesLiveData.postValue(it.content)
                            }
                        } else {
                            Log.d(TAG, "getMovies: Error ${it.detail}")
                        }
                    }.collect()
            }
        }
    }
}