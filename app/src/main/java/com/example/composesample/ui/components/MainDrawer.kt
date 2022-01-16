package com.example.composesample.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composesample.ui.theme.MainTheme

sealed class DrawerItem(val title: String) {
    object Home : DrawerItem("Home")
    object Settings : DrawerItem("Settings")
}

@Composable
fun MainDrawer(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToSettings: () -> Unit
) {
    MainDrawerRaw(
        modifier = modifier,
        navigateToHome = navigateToHome,
        navigateToSettings = navigateToSettings
    )
}

@Composable
fun MainDrawerRaw(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit = {},
    navigateToSettings: () -> Unit = {}
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
            .background(MaterialTheme.colors.background),
    ) {
        DrawerColumnItem(
            item = DrawerItem.Home,
            selected = false,
            onItemClick = { navigateToHome() }
        )
        DrawerColumnItem(
            item = DrawerItem.Settings,
            selected = false,
            onItemClick = { navigateToSettings() }
        )
    }
}

@Composable
fun DrawerColumnItem(item: DrawerItem, selected: Boolean, onItemClick: (DrawerItem) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(item) }
            .height(45.dp)
            .padding(start = 10.dp)
    ) {
        Text(
            text = item.title,
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun MainDrawerPreview() {
    MainTheme {
        MainDrawerRaw()
    }
}
