package com.kudashov.mtsteta_project.util

import com.kudashov.mtsteta_project.data.dto.Actor
import com.kudashov.mtsteta_project.data.dto.Genre
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto

sealed class StateMovieList{
    object Default: StateMovieList()
    object Loading: StateMovieList()
    class LoadMovieList(val list: List<MovieDto>): StateMovieList()
    class LoadGenreList(val list: List<Genre>): StateMovieList()
    class Error<T>(val message: T): StateMovieList()
}

sealed class StateMovie{
    object Default: StateMovie()
    object Loading: StateMovie()
    class LoadMovie(val movie: MovieMoreInfDto): StateMovie()
    class LoadActorList(val list: List<Actor>): StateMovie()
    class Error<T>(val message: T): StateMovie()
}