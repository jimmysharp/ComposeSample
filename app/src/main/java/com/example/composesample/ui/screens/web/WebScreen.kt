package com.example.composesample.ui.screens.web

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun WebScreen(
    navController: NavController,
    viewModel: WebViewModel
) {
    Text(text = "Web Screen")
}