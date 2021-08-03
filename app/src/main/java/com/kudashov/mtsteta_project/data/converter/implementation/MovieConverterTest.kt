package com.kudashov.mtsteta_project.data.converter.implementation

import com.kudashov.mtsteta_project.data.converter.MovieConverter
import com.kudashov.mtsteta_project.data.dto.Genre
import com.kudashov.mtsteta_project.data.dto.MovieDto

class MovieConverterTest: MovieConverter  {

    override fun convertMovieListFromApiToDomain(movie: MovieDto): MovieDto {
        return movie
    }

    override fun convertGenreListFromApiToDomain(genre: Genre): Genre {
        return genre
    }
}