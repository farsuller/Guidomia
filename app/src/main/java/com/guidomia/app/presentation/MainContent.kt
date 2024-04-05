package com.guidomia.app.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.guidomia.app.model.CarModel
import com.guidomia.app.presentation.components.CarDetailCard
import com.guidomia.app.presentation.components.FilterTextFields

@Composable
fun MainContent(cars: List<CarModel>, isCarsLoaded:Boolean = false) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        FilterTextFields()

        if(isCarsLoaded){
            cars.forEach { c->
                CarDetailCard(c)
            }
        }
    }
}