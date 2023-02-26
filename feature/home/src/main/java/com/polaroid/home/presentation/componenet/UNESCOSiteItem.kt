package com.polaroid.home.presentation.componenet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.polaroid.home.R
import com.polaroid.home.domain.entity.UNESCOSiteEntity

@Composable
fun UNESCOSiteItem(
    item: UNESCOSiteEntity
) {
    Column(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .background(
                color = White
            ),
        horizontalAlignment = Alignment.Start
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentScale = ContentScale.Crop,
            model = item.image?.makeSecureUrl(),
            contentDescription = null,
            error = painterResource(R.drawable.image_error),
            placeholder = painterResource(id = R.drawable.image_placeholder)
        )
        Text(
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    top = 16.dp
                )
                .wrapContentWidth(),
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
            ),
            text = item.name!!
        )

    }
}

fun String.makeSecureUrl(): String {
    return this.replace("http://", "https://")
}

