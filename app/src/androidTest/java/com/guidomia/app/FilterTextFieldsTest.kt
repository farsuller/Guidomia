package com.guidomia.app

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.guidomia.app.model.CarModel
import com.guidomia.app.presentation.components.CarDetailCard
import com.guidomia.app.presentation.components.FilterTextFields
import com.guidomia.app.ui.theme.GuidomiaTheme
import com.guidomia.app.util.TestTags.CAR_DETAIL
import com.guidomia.app.util.TestTags.CAR_MAKE
import com.guidomia.app.util.TestTags.CAR_MAKE_FILTER
import com.guidomia.app.util.TestTags.CAR_MODEL_FILTER
import com.guidomia.app.util.TestTags.CAR_PRICE
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FilterTextFieldsTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun onClickCarDetailDisplayed(){

        composeTestRule.setContent {
            GuidomiaTheme {
                FilterTextFields(onMakeFilterChanged = {}, onModelFilterChanged = {})
            }
        }
        composeTestRule.onNodeWithTag(CAR_MAKE_FILTER).assertExists()

        composeTestRule.onNodeWithTag(CAR_MAKE_FILTER).performClick()

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag(CAR_MAKE_FILTER).performTextInput("Your Make Text")

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag(CAR_MODEL_FILTER).assertExists()

        composeTestRule.onNodeWithTag(CAR_MODEL_FILTER).performClick()

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag(CAR_MODEL_FILTER).performTextInput("Your Model Text")

        composeTestRule.waitForIdle()
    }
}