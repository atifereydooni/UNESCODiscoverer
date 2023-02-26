package com.polaroid.home.presentation.componenet

import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.polaroid.home.domain.entity.UNESCOSiteEntity

@Composable
fun UNESCOSiteItem(
    item: UNESCOSiteEntity
) {
    Text(
        modifier = Modifier
            .height(75.dp),
        text = item.name!!,
    )

    Divider()
}
