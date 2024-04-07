package com.guidomia.app

import com.guidomia.app.model.CarModel
import kotlinx.coroutines.test.StandardTestDispatcher
import org.junit.Assert.assertEquals
import org.junit.Test



class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    val mockCarList = listOf(
        CarModel(
            consList = listOf("Bad direction"),
            customerPrice = 120000.0,
            make = "Land Rover",
            marketPrice = 125000.0,
            model = "Range Rover",
            prosList = listOf("You can go everywhere", "Good sound system"),
            rating = 3
        ),
        CarModel(
            consList = listOf("Sometime explode"),
            customerPrice = 220000.0,
            make = "Alpine",
            marketPrice = 225000.0,
            model = "Roadster",
            prosList = listOf("This car is so fast", "Jame Bond would love to steal that car"),
            rating = 4
        ),
        CarModel(
            consList = listOf(
                "You can heard the engine over children cry at the back",
                "You may lose this one if you divorce"
            ),
            customerPrice = 65000.0,
            make = "BMW",
            marketPrice = 55900.0,
            model = "3300i",
            prosList = listOf(
                "Your average business man car",
                "Can bring the family home safely",
                "The city must have"
            ),
            rating = 5
        ),
        CarModel(
            consList = listOf("You may lose a wheel", "Expensive maintenance"),
            customerPrice = 95000.0,
            make = "Mercedes Benz",
            marketPrice = 85900.0,
            model = "GLE coupe",
            prosList = emptyList(),
            rating = 2
        )
    )

    @Test
    fun testMockCarList() = testDispatcher.run {
        val carList = mockCarList
        assertEquals(false, carList.isEmpty())
        assertEquals(4, carList.size)
    }

}