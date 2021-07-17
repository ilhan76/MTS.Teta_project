package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.dto.Genre

class GenreDataSourceImpl: GenreDataSource {

    override fun getGenre(): List<Genre> {
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