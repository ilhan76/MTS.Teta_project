package com.kudashov.mtsteta_project.screens.movieDetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kudashov.mtsteta_project.data.source.impl.MovieProviderTest
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryImpl
import com.kudashov.mtsteta_project.util.StateMovie
import com.kudashov.mtsteta_project.util.extensions.default

class MovieDetailViewModel(val context: Application): AndroidViewModel(context) {
    private val state = MutableLiveData<StateMovie>().default(StateMovie.Default)
    private val repository: MovieRepository = MovieRepositoryImpl(movieProvider = MovieProviderTest())

    fun getStates() : MutableLiveData<StateMovie> {
        return state
    }

    fun getActors(){
        state.postValue(StateMovie.Loading)
    }

    fun getMovieMoreInf(){
        state.postValue(StateMovie.Loading)
    }
}