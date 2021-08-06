package com.kudashov.mtsteta_project.screens.movieList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kudashov.mtsteta_project.data.converter.implementation.MovieConverterImpl
import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.source.impl.MovieProviderImpl
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(val context: Application) : AndroidViewModel(context) {
    private val TAG: String = this::class.java.simpleName
    private val repository: MovieRepository = MovieRepositoryImpl(
        movieProvider = MovieProviderImpl(),
        converter = MovieConverterImpl()
    )

    private val _genresLiveData = MutableLiveData<List<GenreDomain>>()
    val genresLiveData: LiveData<List<GenreDomain>> = _genresLiveData

    private val _moviesLiveData = MutableLiveData<List<MovieDomain>>()
    val moviesLiveData: LiveData<List<MovieDomain>> = _moviesLiveData

    fun getGenres() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = repository.getGenreListAsync().await()

                withContext(Dispatchers.Main) {
                    _genresLiveData.postValue(response.content)
                }
            }
        }
    }

    fun getMovies() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = repository.getMovieListAsync().await()

                withContext(Dispatchers.Main) {
                    _moviesLiveData.postValue(response.content)
                }
            }
        }
    }
}


