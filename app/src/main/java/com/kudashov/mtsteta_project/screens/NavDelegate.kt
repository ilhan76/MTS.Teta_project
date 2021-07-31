package com.kudashov.mtsteta_project.screens

import android.os.Bundle

interface NavDelegate {
    fun fromMovieListToMovieDetails(bundle: Bundle)
    fun fromMovieDetailsToMovieList(bundle: Bundle)
}