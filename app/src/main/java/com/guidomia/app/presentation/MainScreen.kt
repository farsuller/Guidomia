package com.guidomia.app.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.guidomia.app.MainViewModel
import com.guidomia.app.model.CarModel
import com.guidomia.app.presentation.components.CollapsableTopBar
import com.guidomia.app.ui.theme.GuidomiaTheme
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val viewModel: MainViewModel = viewModel()
    var data by remember { mutableStateOf(emptyList<CarModel>()) }
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    var padding by remember { mutableStateOf(PaddingValues()) }

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        viewModel.loadCarsFromJsonFile(context = context, fileName = "car_list.json")

        viewModel.carList.collectLatest {
            data = it
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CollapsableTopBar(scrollBehavior = scrollBehavior)
        },
        content = {
            padding = it

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = padding.calculateTopPadding())
                    .padding(bottom = padding.calculateBottomPadding()),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                item {
                    MainHeader()
                    MainContent(cars = data)
                    MainFooter()
                }
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun MainContentPreview() {
    GuidomiaTheme {
        MainScreen()
    }
}