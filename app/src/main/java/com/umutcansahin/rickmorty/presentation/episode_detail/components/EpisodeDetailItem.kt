package com.umutcansahin.rickmorty.presentation.episode_detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun EpisodeDetailItem(
    character: String?,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(character)
                .crossfade(true)
                .build(),
            //error = painterResource(id = R.drawable.broken_image),
            //placeholder = painterResource(id = R.drawable.loading_image),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun PreviewCharacterList() {
    //"https://rickandmortyapi.com/api/character/avatar/2.jpeg"
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.error)) {
        EpisodeDetailItem(character = "https://rickandmortyapi.com/api/character/avatar/2.jpeg")
    }
}