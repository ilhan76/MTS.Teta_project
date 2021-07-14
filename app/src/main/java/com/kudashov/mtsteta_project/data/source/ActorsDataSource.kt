package com.kudashov.mtsteta_project.data.source

import com.kudashov.mtsteta_project.data.dto.Actor

interface ActorsDataSource {
    fun getActors(): List<Actor>
}