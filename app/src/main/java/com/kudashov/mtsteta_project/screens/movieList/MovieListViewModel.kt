package com.kudashov.mtsteta_project.screens.movieList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kudashov.mtsteta_project.util.extensions.default
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryTest
import com.kudashov.mtsteta_project.util.StateMovieList
import kotlinx.coroutines.launch

class MovieListViewModel(val context: Application) : AndroidViewModel(context) {
    private val state = MutableLiveData<StateMovieList>().default(initialValue = StateMovieList.Default)
    private val repository: MovieRepository = MovieRepositoryTest()

    fun getGenres(){
        state.postValue(StateMovieList.Loading)
    }

    fun getMovies(){
        state.postValue(StateMovieList.Loading)
    }

    fun getStates(): MutableLiveData<StateMovieList>{
        return state
    }
}