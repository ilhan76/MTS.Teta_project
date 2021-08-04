package com.kudashov.mtsteta_project.screens.movieDetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kudashov.mtsteta_project.data.converter.implementation.MovieConverterTest
import com.kudashov.mtsteta_project.data.dto.Actor
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto
import com.kudashov.mtsteta_project.data.source.impl.MovieProviderTest
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryImpl
import com.kudashov.mtsteta_project.util.StateMovie
import com.kudashov.mtsteta_project.util.extensions.default
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(val context: Application) : AndroidViewModel(context) {
    private val TAG: String = this::class.java.simpleName
    private val repository: MovieRepository = MovieRepositoryImpl(
        movieProvider = MovieProviderTest(),
        converter = MovieConverterTest()
    )

    private val _movieMoreInfLiveData = MutableLiveData<MovieMoreInfDto>()
    val movieMoreInfLiveData: LiveData<MovieMoreInfDto> = _movieMoreInfLiveData

    fun loadPage(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val movieMoreInf = repository.getMovieMoreInfAsync(id).await()

                _movieMoreInfLiveData.postValue(movieMoreInf.movie)
            }
        }
    }

}