package com.kudashov.mtsteta_project.screens.movieDetail

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kudashov.mtsteta_project.data.converter.implementation.MovieConverterImpl
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.room.AppDatabase
import com.kudashov.mtsteta_project.data.source.impl.RemoteMovieProviderImpl
import com.kudashov.mtsteta_project.data.source.impl.RoomMovieProvider
import com.kudashov.mtsteta_project.repository.MovieRepository
import com.kudashov.mtsteta_project.repository.implementation.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onErrorCollect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailViewModel(val context: Application) : AndroidViewModel(context) {
    private val TAG: String = this::class.java.simpleName
    private val repository: MovieRepository = MovieRepositoryImpl(
        localMovieProvider = RoomMovieProvider(AppDatabase.getInstance(getApplication())),
        remoteMovieProvider = RemoteMovieProviderImpl(),
        converter = MovieConverterImpl()
    )

    private val _movieMoreInfLiveData = MutableLiveData<MovieMoreInfDomain>()
    val movieMoreInfLiveData: LiveData<MovieMoreInfDomain> = _movieMoreInfLiveData

    fun loadPage(id: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.getMovieMoreInf(id)
                    .onEach {
                        if (it.content != null) {
                            withContext(Dispatchers.Main) {
                                _movieMoreInfLiveData.postValue(it.content)
                            }
                        } else {
                            Log.d(TAG, "getMovies: Error ${it.detail}")
                        }
                    }.collect()
/*                val movieMoreInf = repository.getMovieMoreInf(id).await()

                withContext(Dispatchers.Main) {
                    _movieMoreInfLiveData.postValue(movieMoreInf.content)
                }*/
            }
        }
    }

}