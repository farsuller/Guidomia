package com.guidomia.app

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performGesture
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.guidomia.app.model.CarModel
import com.guidomia.app.presentation.MainScreen
import com.guidomia.app.presentation.components.CarDetailCard
import com.guidomia.app.presentation.components.FilterTextFields
import com.guidomia.app.ui.theme.GuidomiaTheme
import com.guidomia.app.util.TestTags.CAR_DETAIL
import com.guidomia.app.util.TestTags.CAR_MAKE
import com.guidomia.app.util.TestTags.CAR_MAKE_FILTER
import com.guidomia.app.util.TestTags.CAR_MODEL_FILTER
import com.guidomia.app.util.TestTags.CAR_PRICE
import com.guidomia.app.util.TestTags.MAIN_SCREEN
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testScrollUp(){

        composeTestRule.setContent {
            GuidomiaTheme {
                MainScreen()
            }
        }
        composeTestRule.onNodeWithTag(MAIN_SCREEN).performTouchInput{
            swipe(
                start = Offset(x = 0.5f, y = 0.8f),
                end = Offset(x = 0.5f, y = 0.2f),
                durationMillis = 5000 // Adjust as needed
            )
        }
    }
}