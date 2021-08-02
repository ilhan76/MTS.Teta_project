package com.kudashov.mtsteta_project.util.extensions

import androidx.lifecycle.MutableLiveData

fun <T :Any?> MutableLiveData<T>.default(initialValue: T) = apply { value = initialValue }