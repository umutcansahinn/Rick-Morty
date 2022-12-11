package com.umutcansahin.rickmorty.presentation.character_detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.umutcansahin.rickmorty.R

@Composable
fun CharacterDetailImageItem(
    image: String?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            error = painterResource(id = R.drawable.broken_image),
            placeholder = painterResource(id = R.drawable.downloading_image),
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )
        Spacer(modifier = modifier.padding(16.dp))
    }
}