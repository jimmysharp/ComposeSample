package com.example.composesample.ui.screens.tutorial

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TutorialScreen(
    navController: NavController,
    viewModel: TutorialViewModel
) {
    Text(text = "Tutorial Screen")
}