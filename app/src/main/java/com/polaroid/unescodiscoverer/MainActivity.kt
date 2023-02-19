package com.polaroid.unescodiscoverer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.polaroid.navigation.INavigationManager
import com.polaroid.theme.UNESCODiscovererTheme
import com.polaroid.unescodiscoverer.navigation.MainScaffold
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationManager: INavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UNESCODiscovererTheme {
                MainScaffold(
                    navigationManager = navigationManager
                )
            }
        }
    }
}