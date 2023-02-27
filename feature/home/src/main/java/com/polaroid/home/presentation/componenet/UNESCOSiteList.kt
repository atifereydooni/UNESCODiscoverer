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
import androidx.compose.ui.platform.testTag
import com.polaroid.home.presentation.ListState
import com.polaroid.home.presentation.UNESCOSiteState

const val TAG_LIST = "TAG_LIST"

@Composable
fun UNESCOSiteList(
    lazyColumnListState: LazyListState,
    unescoSiteState: UNESCOSiteState
) {

    val articles = unescoSiteState.UNESCOSiteList

    LazyColumn(
        modifier = Modifier.testTag(TAG_LIST),
        state = lazyColumnListState
    ) {
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