package com.guidomia.app.model

import androidx.compose.runtime.Immutable

@Immutable
data class CarModel(
    val consList: List<String>,
    val customerPrice: Double,
    val make: String,
    val marketPrice: Double,
    val model: String,
    val prosList: List<Any>,
    val rating: Int
)