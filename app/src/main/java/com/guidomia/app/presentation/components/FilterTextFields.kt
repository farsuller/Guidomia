package com.guidomia.app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.guidomia.app.R
import com.guidomia.app.ui.theme.GuidomiaTheme
import com.guidomia.app.util.TestTags.CAR_MAKE_FILTER
import com.guidomia.app.util.TestTags.CAR_MODEL_FILTER
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FilterTextFields(
    onMakeFilterChanged: (String) -> Unit,
    onModelFilterChanged: (String) -> Unit
) {

    var makeFilter by remember { mutableStateOf("") }
    var modelFilter by remember { mutableStateOf("") }

    var job by remember { mutableStateOf<Job?>(null) }


    Box(
        modifier = Modifier
            .padding(10.dp)
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = MaterialTheme.shapes.medium
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(10.dp)) {

            Text(
                modifier = Modifier.padding(start = 5.dp),
                text = stringResource(id = R.string.filter),
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                fontWeight = MaterialTheme.typography.titleMedium.fontWeight,
                color = MaterialTheme.colorScheme.surface,
            )

            TextField(
                value = makeFilter,
                onValueChange = {
                    makeFilter = it
                    job?.cancel() // Cancel previous debounce job
                    job = CoroutineScope(Dispatchers.Default).launch {
                        delay(300) // Debounce time in milliseconds
                        onMakeFilterChanged(it) // Execute filtering after debounce
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .testTag(CAR_MAKE_FILTER),
                label = { Text("any make") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent
                ),
                maxLines = 1,
                singleLine = true,
                shape = MaterialTheme.shapes.medium
            )
            TextField(
                value = modelFilter,
                onValueChange = {
                    modelFilter = it
                    job?.cancel() // Cancel previous debounce job
                    job = CoroutineScope(Dispatchers.Default).launch {
                        delay(300) // Debounce time in milliseconds
                        onModelFilterChanged(it) // Execute filtering after debounce
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .testTag(CAR_MODEL_FILTER),
                label = { Text("any model") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent
                ),
                maxLines = 1,
                singleLine = true,
                shape = MaterialTheme.shapes.medium
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FilterTextFieldsPreview() {
    GuidomiaTheme {
        FilterTextFields(onMakeFilterChanged = {}, onModelFilterChanged = {})
    }
}