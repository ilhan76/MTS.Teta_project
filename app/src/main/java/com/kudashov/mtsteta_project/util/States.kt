package com.kudashov.mtsteta_project.util

import com.kudashov.mtsteta_project.data.domain.ActorDomain
import com.kudashov.mtsteta_project.data.dto.GenreDto
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain

/*sealed class StateMovieList{
    object Default: StateMovieList()
    object Loading: StateMovieList()
    class LoadedState(val genres: List<Genre>, movies: List<MovieDto>): StateMovieList()
    //class LoadedMovieList(val list: List<MovieDto>): StateMovieList()
    object NoListItem: StateMovieList()
    class NoMovieListItem(val genres: List<Genre>): StateMovieList()
    class NoGenreListItem(val movie: List<MovieDto>): StateMovieList()
    //class LoadedGenreList(val list: List<Genre>): StateMovieList()
    //object NoGenreListItem: StateMovieList()
    class Error<T>(val message: T): StateMovieList()
}*/

sealed class StateMovieList{
    object Default: StateMovieList()
    object Loading: StateMovieList()
    class LoadedMovieList(val list: List<MovieDomain>): StateMovieList()
    object NoMovieListItem : StateMovieList()
    class LoadedGenreList(val list: List<GenreDto>): StateMovieList()
    object NoGenreListItem: StateMovieList()
    class Error<T>(val message: T): StateMovieList()
}

sealed class StateMovie{
    object Default: StateMovie()
    object Loading: StateMovie()
    class LoadMovie(val movie: MovieMoreInfDomain): StateMovie()
    class LoadActorList(val list: List<ActorDomain>): StateMovie()
    class Error<T>(val message: T): StateMovie()
}