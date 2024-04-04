package com.guidomia.app.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guidomia.app.MainViewModel
import com.guidomia.app.model.CarModel
import com.guidomia.app.ui.theme.GuidomiaTheme

@Composable
fun MainScreen(){
    val viewModel: MainViewModel = viewModel()
    val data = viewModel.getCarList(LocalContext.current)

    Header()
    MainContent(cars = data)
    Footer()
}

@Composable
fun Header(){

}

@Composable
fun MainContent(cars: List<CarModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ){
        items(cars){ car->

            Text(text = car.make)
        }
    }
}

@Composable
fun Footer(){

}

@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    GuidomiaTheme {

        val cars = listOf(
            CarModel(
                make = "Land Rover",
                model = "Range Rover",
                customerPrice = 120000.0,
                marketPrice = 125000.0,
                rating = 3,
                prosList = listOf("You can go everywhere", "Good sound system"),
                consList = listOf("Bad direction")
            )
        )
        MainContent(cars = cars)
    }
}