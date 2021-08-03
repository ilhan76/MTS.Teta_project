package com.kudashov.mtsteta_project.screens.movieList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kudashov.mtsteta_project.data.source.impl.MovieProviderTest
import com.kudashov.mtsteta_project.util.extensions.default
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryImpl
import com.kudashov.mtsteta_project.util.StateMovieList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel(val context: Application) : AndroidViewModel(context) {
    private val TAG: String = this::class.java.simpleName
    private val state =
        MutableLiveData<StateMovieList>().default(initialValue = StateMovieList.Default)
    private val repository: MovieRepository =
        MovieRepositoryImpl(movieProvider = MovieProviderTest())

    fun getGenresAsync() {
        state.postValue(StateMovieList.Loading)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val genres = repository.getGenreListAsync().await()

                if (genres.list != null && genres.list.isNotEmpty()) {
                    launch (Dispatchers.Main){
                        state.postValue(StateMovieList.LoadedGenreList(genres.list))
                    }
                } else {
                    launch (Dispatchers.Main){
                        state.postValue(StateMovieList.NoGenreListItem)
                    }
                }
            }
        }
    }

    fun getMoviesAsync() {
        state.postValue(StateMovieList.Loading)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val movies = repository.getMovieListAsync().await()

                if (movies.list != null && movies.list.isNotEmpty()) {
                    launch (Dispatchers.Main){
                        state.postValue(StateMovieList.LoadedMovieList(movies.list))
                    }
                } else {
                    launch (Dispatchers.Main){
                        state.postValue(StateMovieList.NoMovieListItem)
                    }
                }
            }
        }
    }

    fun getStates(): MutableLiveData<StateMovieList> {
        return state
    }
}

