package com.polaroid.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(viewModel: HomeViewModel) {

    val lazyColumnListState = rememberLazyListState()

    val shouldStartPaginate = remember {
        derivedStateOf {
            viewModel.unescoSiteState.value.canPaginate &&
                    (lazyColumnListState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                        ?: -9) >= (lazyColumnListState.layoutInfo.totalItemsCount - 6)
        }
    }

    val articles = viewModel.unescoSiteState.value.UNESCOSiteList

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value && viewModel.unescoSiteState.value.listState == ListState.IDLE)
            viewModel.getUNESCOSite()
    }

    LazyColumn(state = lazyColumnListState) {
        itemsIndexed(articles) { index, item ->
            Text(
                modifier = Modifier
                    .height(75.dp),
                text = item.name!!,
            )
            Text(
                modifier = Modifier
                    .height(75.dp),
                text = index.toString(),
            )

            Divider()
        }

        item(
            key = viewModel.unescoSiteState.value.listState,
        ) {
            when (viewModel.unescoSiteState.value.listState) {
                ListState.PAGINATING -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Pagination Loading")

                        CircularProgressIndicator(color = Color.Black)
                    }
                }
                else -> {}
            }
        }
    }
}