package com.kudashov.mtsteta_project.data.source.impl

import com.kudashov.mtsteta_project.data.dto.Genre
import com.kudashov.mtsteta_project.data.source.GenreDataSource

class GenreDataSourceImpl : GenreDataSource {

    override fun getGenres(): List<Genre> {
        return listOf(
                Genre("боевики"),
                Genre("драмы"),
                Genre("комедия"),
                Genre("артхаус"),
                Genre("мелодрамы"),
                Genre("фантастика"),
                Genre("фентези"),
                Genre("вестерн"),
                Genre("аниме"),
                Genre("документальный")
        )
    }
}