package com.umutcansahin.rickmorty.presentation.character_detail.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CharacterDetailTextItem(
    text: String?,
) {
    Text(
        text = text ?: "null",
        style = MaterialTheme.typography.h6,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Center,
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Divider()
}