package com.kudashov.mtsteta_project.data.converter

import com.kudashov.mtsteta_project.data.domain.GenreDomain
import com.kudashov.mtsteta_project.data.dto.GenreDto
import com.kudashov.mtsteta_project.data.domain.MovieDomain
import com.kudashov.mtsteta_project.data.domain.MovieMoreInfDomain
import com.kudashov.mtsteta_project.data.dto.MovieDto
import com.kudashov.mtsteta_project.data.dto.MovieMoreInfDto
import com.kudashov.mtsteta_project.data.room.entity.GenreEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieEntity
import com.kudashov.mtsteta_project.data.room.entity.MovieMoreInfEntity

interface MovieConverter {
    fun convertMovieListFromApiToDomain(movieDto: MovieDto): MovieDomain
    fun convertMovieListFromEntityToDomain(movieEntity: MovieEntity): MovieDomain
    fun convertMovieListFromDtoToEntity(movieDto: MovieDto): MovieEntity

    fun convertGenreListFromApiToDomain(genreDto: GenreDto): GenreDomain
    fun convertGenreListFromEntityToDomain(genreEntity: GenreEntity): GenreDomain
    fun convertGenreListFromDtoToEntity(genreDto: GenreDto): GenreEntity

    fun convertMovieMoreInfFromApiToDomain(movieMoreInfDto: MovieMoreInfDto): MovieMoreInfDomain
    fun convertMovieMoreInfFromEntityToDomain(movieMoreInfEntity: MovieMoreInfEntity): MovieMoreInfDomain
    fun convertMovieMoreInfFromDtoToEntity(movieMoreInfDto: MovieMoreInfDto): MovieMoreInfEntity
}