package com.kudashov.mtsteta_project.data.room.dao

import androidx.room.*
import com.kudashov.mtsteta_project.data.room.entity.ActorEntity

@Dao
interface ActorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addActor(actorEntity: ActorEntity)

    @Delete
    fun deleteActor(actorEntity: ActorEntity)
}