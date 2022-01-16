package com.example.composesample.ui.screens.login

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel
) {
    Text(text = "Login Screen")
}
