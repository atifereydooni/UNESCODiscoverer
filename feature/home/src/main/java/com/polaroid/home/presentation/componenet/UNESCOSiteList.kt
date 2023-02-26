package com.polaroid.home.presentation.componenet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.polaroid.home.presentation.ListState
import com.polaroid.home.presentation.UNESCOSiteState

@Composable
fun UNESCOSiteList(
    lazyColumnListState: LazyListState,
    unescoSiteState: UNESCOSiteState
) {

    val articles = unescoSiteState.UNESCOSiteList

    LazyColumn(state = lazyColumnListState) {
        itemsIndexed(articles) { _, item ->
            UNESCOSiteItem(item = item)
        }

        item(
            key = unescoSiteState
                .listState,
        ) {
            when (unescoSiteState.listState) {
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