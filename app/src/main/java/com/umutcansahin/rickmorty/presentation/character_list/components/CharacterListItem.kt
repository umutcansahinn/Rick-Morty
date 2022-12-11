package com.umutcansahin.rickmorty.presentation.character_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.umutcansahin.rickmorty.domain.model.character.CharacterResult

@Composable
fun CharacterListItem(
    character: CharacterResult,
    onItemClick: (CharacterResult) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(character) }
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
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
            Spacer(modifier = Modifier.padding(end = 8.dp))
            Column {
                Text(
                    text = character.name ?: "null",
                    style = MaterialTheme.typography.h6,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.padding(end = 8.dp))
                Text(
                    text = character.status ?: "null",
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCharacterListItem() {
    val character = CharacterResult(
        status = "alive",
        name = "rick",
        image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
        id = 2
    )
    Surface(modifier = Modifier.fillMaxSize()) {
        CharacterListItem(character = character, onItemClick = {})
    }
}