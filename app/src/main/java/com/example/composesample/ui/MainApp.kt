package com.example.composesample.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.composesample.ui.screens.home.HomeScreen
import com.example.composesample.ui.screens.home.HomeViewModel
import com.example.composesample.ui.screens.login.LoginScreen
import com.example.composesample.ui.screens.login.LoginViewModel
import com.example.composesample.ui.screens.overlayweb.OverlayWebScreen
import com.example.composesample.ui.screens.overlayweb.OverlayWebViewModel
import com.example.composesample.ui.screens.settings.SettingsScreen
import com.example.composesample.ui.screens.settings.SettingsViewModel
import com.example.composesample.ui.screens.tutorial.TutorialScreen
import com.example.composesample.ui.screens.tutorial.TutorialViewModel
import com.example.composesample.ui.screens.web.WebScreen
import com.example.composesample.ui.screens.web.WebViewModel

@Composable
fun MainApp(
    appState: MainAppState = rememberMainAppState()
) {
    NavHost(
        navController = appState.navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { _ ->
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                navController = appState.navController,
                viewModel = viewModel
            )
        }
        composable(Screen.Web.route) { _ ->
            val viewModel = hiltViewModel<WebViewModel>()
            WebScreen(
                navController = appState.navController,
                viewModel = viewModel
            )
        }
        composable(Screen.OverlayWeb.route) { _ ->
            val viewModel = hiltViewModel<OverlayWebViewModel>()
            OverlayWebScreen(
                navController = appState.navController,
                viewModel = viewModel
            )
        }
        composable(Screen.Settings.route) { _ ->
            val viewModel = hiltViewModel<SettingsViewModel>()
            SettingsScreen(
                navController = appState.navController,
                viewModel = viewModel
            )
        }
        composable(Screen.Login.route) { _ ->
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                navController = appState.navController,
                viewModel = viewModel
            )
        }
        composable(Screen.Tutorial.route) { _ ->
            val viewModel = hiltViewModel<TutorialViewModel>()
            TutorialScreen(
                navController = appState.navController,
                viewModel = viewModel
            )
        }
    }
}