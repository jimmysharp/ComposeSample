package com.example.composesample.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composesample.ui.theme.MainTheme

private val AppBarHorizontalPadding = 4.dp
private val TitleIconModifier = Modifier
    .fillMaxHeight()
    .width(72.dp - AppBarHorizontalPadding)

@Composable
fun MainAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.BottomAppBarElevation,
    navigationIcon: @Composable (() -> Unit)? = null,
    title: @Composable () -> Unit,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation
    ) {
        ConstraintLayout {
            val (navIconRef, titleRef, actionsRef) = createRefs()

            // Navigation Icon
            if (navigationIcon != null) {
                Row(
                    TitleIconModifier.constrainAs(navIconRef) {
                        start.linkTo(parent.start)
                    },
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.high,
                        content = navigationIcon
                    )
                }
            }

            // Title
            Row(
                Modifier
                    .fillMaxSize()
                    .constrainAs(titleRef) {
                        centerTo(parent)
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                ProvideTextStyle(value = MaterialTheme.typography.h6) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.high,
                        content = title
                    )
                }
            }

            // Actions
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Row(
                    Modifier
                        .fillMaxHeight()
                        .constrainAs(actionsRef) {
                            end.linkTo(parent.end)
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    content = actions
                )
            }
        }
    }
}

@Preview
@Composable
fun MainAppBarPreviewWithNoIcons() {
    MainTheme {
        MainAppBar(title = { Text("Preview") })
    }
}

@Preview
@Composable
fun MainAppBarPreviewWithIcons() {
    MainTheme {
        MainAppBar(
            title = {
                Text(
                    "Preview"
                )
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings")
                }
            }
        )
    }
}
