package com.kudashov.mtsteta_project.data.room.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.kudashov.mtsteta_project.data.room.entity.relations.MovieGenreCrossRef

data class MovieMoreInfEntity(
    @Embedded
    val movieEntity: MovieEntity,
    @Relation(
        parentColumn = "movie_id",
        entityColumn = "genre_id",
        associateBy = Junction(MovieGenreCrossRef::class)
    )
    val genres: List<GenreEntity>
/*    @Relation(
        parentColumn = "movie_id",
        entityColumn = "actor_id",
        associateBy = Junction(MovieActorCrossRef::class)
    )
    val actors: List<ActorEntity>*/
)