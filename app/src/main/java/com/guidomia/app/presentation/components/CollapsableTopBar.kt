package com.guidomia.app.presentation.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.guidomia.app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CollapsableTopBar(scrollBehavior: TopAppBarScrollBehavior) {

    TopAppBar(
        scrollBehavior = scrollBehavior,
        navigationIcon = {

        },
        title = {
            Text(
                modifier = Modifier.padding(end = 10.dp),
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.surface,
            )
        },
        actions = {
            Icon(
                modifier = Modifier.padding(end = 10.dp),
                imageVector = Icons.Default.Menu,
                tint = MaterialTheme.colorScheme.surface,
                contentDescription = "Logo Image",
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
    )
}