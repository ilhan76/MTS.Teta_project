package com.kudashov.mtsteta_project.data.room.entity.relations

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(
    primaryKeys = ["movie_id", "genre_id"],
    tableName = MovieGenreCrossRef.TABLE_NAME
)
data class MovieGenreCrossRef(
    @ColumnInfo(name = "movie_id")
    val movieId: Int,
    @ColumnInfo(name = "genre_id")
    val genreId: Int
){
    companion object{
        const val TABLE_NAME = "movie_genre_table"
    }
}
