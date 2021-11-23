package com.example.composesample.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composesample.ui.screens.HomeScreen
import com.example.composesample.ui.screens.login.LoginScreen
import com.example.composesample.ui.screens.overlayweb.OverlayWebScreen
import com.example.composesample.ui.screens.settings.SettingsScreen
import com.example.composesample.ui.screens.tutorial.TutorialScreen
import com.example.composesample.ui.screens.web.WebScreen

@Composable
fun MainApp(
    appState: MainAppState = rememberMainAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { _ ->
            HomeScreen()
        }
        composable(Screen.Web.route) { _ ->
            WebScreen()
        }
        composable(Screen.OverlayWeb.route) { _ ->
            OverlayWebScreen()
        }
        composable(Screen.Settings.route) { _ ->
            SettingsScreen()
        }
        composable(Screen.Login.route) { _ ->
            LoginScreen()
        }
        composable(Screen.Tutorial.route) { _ ->
            TutorialScreen()
        }
    }
}