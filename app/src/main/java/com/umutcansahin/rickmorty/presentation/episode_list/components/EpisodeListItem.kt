package com.umutcansahin.rickmorty.presentation.episode_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umutcansahin.rickmorty.domain.model.episode.EpisodeResult

@Composable
fun EpisodeListItem(
    result: EpisodeResult,
    onItemClick: (EpisodeResult) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(result) }
            .padding(10.dp),
        horizontalArrangement =Arrangement.Start
    ) {

        Text(
            text = result.episode ?: "null" ,
            style = MaterialTheme.typography.h6,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(CenterVertically)
        )
        Spacer(modifier = Modifier.padding(end = 8.dp))
        Text(
            text = result.name ?: "null",
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(CenterVertically)
        )
    }
}


@Preview
@Composable
private fun PreviewEpisodeListItem() {
    /*
    val result = CharacterResultDto(
        episode = listOf("S03E07") ,
        id = listOf(1),
        name = listOf("The Ricklantis Mixup"),
    )
    */
    val result = EpisodeResult(
        episode = "S03E07",
        id = 1,
        name = "The Ricklantis Mixup"
    )
    Surface(modifier = Modifier.fillMaxWidth()) {
        EpisodeListItem(result = result, onItemClick = {})
    }
}