package com.guidomia.app

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.guidomia.app.model.CarModel
import com.guidomia.app.presentation.components.CarDetailCard
import com.guidomia.app.ui.theme.GuidomiaTheme
import com.guidomia.app.util.TestTags.CAR_DETAIL
import com.guidomia.app.util.TestTags.CAR_IMAGE
import com.guidomia.app.util.TestTags.CAR_MAKE
import com.guidomia.app.util.TestTags.CAR_PRICE
import com.guidomia.app.util.TestTags.CAR_PROS_CONS
import com.guidomia.app.util.TestTags.CAR_RATE
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CarDetailCardTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    private val testCarModel = CarModel(
        consList = listOf("Limited color options", "Average fuel efficiency"),
        customerPrice = 35000.0,
        make = "Toyota",
        marketPrice = 38000.0,
        model = "Camry",
        prosList = listOf("Reliable engine", "Comfortable ride", "Spacious interior"),
        rating = 4
    )

    @Test
    fun onCarDetailDisplayed() {

        composeTestRule.setContent {
            GuidomiaTheme {
                CarDetailCard(testCarModel)
            }
        }

        composeTestRule.onNodeWithTag(CAR_DETAIL).assertExists()

        composeTestRule.onNodeWithTag(CAR_IMAGE, useUnmergedTree = true).assertExists()

        composeTestRule.onNodeWithTag(CAR_MAKE, useUnmergedTree = true).assertExists()

        composeTestRule.onNodeWithTag(CAR_PRICE, useUnmergedTree = true).assertExists()

        composeTestRule.onNodeWithTag(CAR_RATE, useUnmergedTree = true).assertExists()

        composeTestRule.waitForIdle()
    }


    @Test
    fun onCarDetailClicked() {
        composeTestRule.setContent {
            GuidomiaTheme {
                CarDetailCard(testCarModel)
            }
        }

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag(CAR_DETAIL).assertExists()

        composeTestRule.onNodeWithTag(CAR_DETAIL).performClick()

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag(CAR_PROS_CONS, useUnmergedTree = true).assertExists()
    }
}