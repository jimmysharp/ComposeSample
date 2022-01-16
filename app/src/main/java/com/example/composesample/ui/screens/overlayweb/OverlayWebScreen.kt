package com.example.composesample.ui.screens.overlayweb

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun OverlayWebScreen(
    navController: NavController,
    viewModel: OverlayWebViewModel
) {
    Text(text = "Overlay Web Screen")
}
