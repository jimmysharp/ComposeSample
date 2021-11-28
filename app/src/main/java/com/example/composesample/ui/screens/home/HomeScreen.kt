package com.example.composesample.ui.screens.home

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.composesample.ui.components.MainAppBar
import com.example.composesample.ui.screens.home.HomeViewModel
import com.example.composesample.ui.theme.MainTheme

@Composable
fun HomeScreen(
    navigateToSettings: () -> Unit,
    viewModel: HomeViewModel
) {
    HomeScreenRaw(
        navigateToSettings = navigateToSettings
    )
}

@Composable
fun HomeScreenRaw(
    navigateToSettings: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            MainAppBar(
                title = { Text(text = "Home") },
                navigationIcon = { IconButton(onClick = {}) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                } },
                actions = { IconButton(onClick = { navigateToSettings() }) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings")
                } }
            )
        }
    ) {
        Text(text = "Home Screen")
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MainTheme {
        HomeScreenRaw()
    }
}