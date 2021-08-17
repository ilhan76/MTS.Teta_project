package com.kudashov.mtsteta_project.screens.movieDetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kudashov.mtsteta_project.data.converter.implementation.MovieConverterImpl
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.source.impl.RemoteMovieProviderImpl
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(val context: Application) : AndroidViewModel(context) {
    private val TAG: String = this::class.java.simpleName
    private val repository: MovieRepository = MovieRepositoryImpl(
        movieProvider = RemoteMovieProviderImpl(),
        converter = MovieConverterImpl()
    )

    private val _movieMoreInfLiveData = MutableLiveData<MovieMoreInfDomain>()
    val movieMoreInfLiveData: LiveData<MovieMoreInfDomain> = _movieMoreInfLiveData

    fun loadPage(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val movieMoreInf = repository.getMovieMoreInfAsync(id).await()

                withContext(Dispatchers.Main) {
                    _movieMoreInfLiveData.postValue(movieMoreInf.content)
                }
            }
        }
    }

}