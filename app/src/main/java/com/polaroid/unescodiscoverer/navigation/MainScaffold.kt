package com.polaroid.unescodiscoverer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.polaroid.navigation.INavigationManager
import com.polaroid.navigation.NavigationEvent
import com.polaroid.navigation.destination.HomeDestination


@Composable
fun MainScaffold(
    navigationManager: INavigationManager
) {
    val navController = rememberAnimatedNavController()
    NavigationEvent(
        navController = navController,
        navigationManager = navigationManager
    )
    AnimatedNavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        builder = {
            addComposableDestinations()
        }
    )
}

@Composable
private fun NavigationEvent(
    navController: NavHostController,
    navigationManager: INavigationManager
) {
    LaunchedEffect(navController) {
        navigationManager.navigationEvents.collect {
            when (val event = it) {
                is NavigationEvent.NavigateUp -> navController.navigateUp()
                is NavigationEvent.NavigateTo ->
                    navController.navigate(
                        event.route,
                        event.builder
                    )
                else -> {}
            }
        }
    }
}

