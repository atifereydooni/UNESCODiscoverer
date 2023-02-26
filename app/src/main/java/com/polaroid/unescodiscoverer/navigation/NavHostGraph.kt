package com.polaroid.unescodiscoverer.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.polaroid.home.presentation.HomeScreen
import com.polaroid.home.presentation.HomeViewModel
import com.polaroid.navigation.destination.HomeDestination
import com.polaroid.navigation.destination.NavigationDestination

private fun composableDestinations(): Map<NavigationDestination, @Composable () -> Unit> =
    mapOf(
        HomeDestination to {
            val homeViewModel: HomeViewModel = hiltViewModel()
            HomeScreen(homeViewModel)
        }
    )

fun NavGraphBuilder.addComposableDestinations() {
    composableDestinations().forEach { entry ->
        val destination = entry.key
        composable(
            destination.route, destination.arguments, destination.deepLinks
        ) {
            entry.value()
        }
    }
}

