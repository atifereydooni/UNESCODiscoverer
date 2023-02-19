package com.polaroid.unescodiscoverer.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.polaroid.navigation.destination.HomeDestination
import com.polaroid.navigation.destination.NavigationDestination

private fun composableDestinations(): Map<NavigationDestination, @Composable () -> Unit> =
    mapOf(
        HomeDestination to {
            HomeScreen()
        }
    )

@Composable
fun HomeScreen() {
    Text(text = "Home Screen")
}

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

