package com.guidomia.app.model

import androidx.annotation.DrawableRes
import com.guidomia.app.R


enum class Cars(
    @DrawableRes val imagePath: Int = 0,
    val title: String = "",
    val model: String = ""
) {
    Alpine(
        imagePath = R.drawable.alphine,
        title = "Alpine",
        model = "Roadster"
    ),

    BMW(
        imagePath = R.drawable.bmw,
        title = "BMW",
        model = "3300i"
    ),
    MercedesBenz(
        imagePath = R.drawable.mercedez,
        title = "Mercedes Benz",
        model = "GLE coupe"
    ),
    LandRover(
        imagePath = R.drawable.range_rover,
        title = "Land Rover",
        model = "Range Rover"
    ),

    Tacoma(
        imagePath = R.drawable.tacoma,
        title = "Tacoma",
    ),

}