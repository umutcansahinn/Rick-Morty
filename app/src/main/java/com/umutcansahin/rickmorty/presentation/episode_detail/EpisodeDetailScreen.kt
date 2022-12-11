package com.umutcansahin.rickmorty.presentation.episode_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.umutcansahin.rickmorty.presentation.episode_detail.components.EpisodeDetailItem

@Composable
fun EpisodeDetailScreen(
    viewModel: EpisodeDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.episodeDetail?.let { episodeDetail ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Text(
                            text = "name: ",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.padding(end = 8.dp))
                        Text(
                            text = episodeDetail.name ?: "null",
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Text(
                            text = "episode: ",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.padding(end = 8.dp))
                        Text(
                            text = episodeDetail.episode ?: "null",
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Text(
                            text = "date:",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.padding(end = 8.dp))
                        Text(
                            text = episodeDetail.airDate ?: "null",
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {

                        Text(
                            text = "created:",
                            style = MaterialTheme.typography.h6,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                        Spacer(modifier = Modifier.padding(end = 8.dp))
                        Text(
                            text = episodeDetail.created ?: "null",
                            fontStyle = FontStyle.Italic,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(episodeDetail.characters!!) { character ->
                    EpisodeDetailItem(
                        character = character,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    Divider()
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
