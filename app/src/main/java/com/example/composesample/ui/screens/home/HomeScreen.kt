package com.example.composesample.ui.screens.home

import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.composesample.ui.components.MainAppBar
import com.example.composesample.ui.components.MainDrawer
import com.example.composesample.ui.theme.MainTheme
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navigateToSettings: () -> Unit,
    viewModel: HomeViewModel
) {
    HomeScreenRaw(
        navigateToHome = {},
        navigateToSettings = navigateToSettings
    )
}

@Composable
fun HomeScreenRaw(
    navigateToHome: () -> Unit = {},
    navigateToSettings: () -> Unit = {}
) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MainAppBar(
                title = { Text(text = "Home") },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = { navigateToSettings() }) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                }
            )
        },
        drawerContent = {
            MainDrawer(
                navigateToHome = {
                    navigateToHome()
                    scope.launch { scaffoldState.drawerState.close() }
                },
                navigateToSettings = {
                    navigateToSettings()
                    scope.launch { scaffoldState.drawerState.close() }
                }
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
