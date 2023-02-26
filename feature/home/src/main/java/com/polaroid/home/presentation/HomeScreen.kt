package com.polaroid.home.presentation

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import com.polaroid.home.presentation.componenet.UNESCOSiteList

@Composable
fun HomeScreen(
    unescoSiteState: UNESCOSiteState,
    onGetUNESCOSite: () -> Unit
) {

    val lazyColumnListState = rememberLazyListState()

    val shouldStartPaginate = remember {
        derivedStateOf {
            unescoSiteState.canPaginate &&
                    (lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                        ?: -9) >= (lazyColumnListState.layoutInfo.totalItemsCount - 6)
        }
    }

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value && unescoSiteState.listState == ListState.IDLE) {
            onGetUNESCOSite()
        }
    }

    UNESCOSiteList(
        lazyColumnListState = lazyColumnListState,
        unescoSiteState = unescoSiteState
    )
}