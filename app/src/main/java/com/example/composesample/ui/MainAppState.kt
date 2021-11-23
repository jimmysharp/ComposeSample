package com.example.composesample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Web: Screen("web")
    object OverlayWeb: Screen("web-over")
    object Settings: Screen("settings")
    object Login: Screen("login")
    object Tutorial: Screen("tutorial")
}

class MainAppState(
    val navController: NavHostController
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}

@Composable
fun rememberMainAppState(
    navController: NavHostController = rememberNavController()
) = remember(navController) {
    MainAppState(navController)
}