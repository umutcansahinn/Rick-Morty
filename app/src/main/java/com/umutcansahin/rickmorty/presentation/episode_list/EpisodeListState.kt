package com.umutcansahin.rickmorty.presentation.episode_list

import com.umutcansahin.rickmorty.domain.model.episode.EpisodeResult

data class EpisodeListState(
    val isLoading: Boolean = false,
    val episodes: List<EpisodeResult?>? = emptyList(),
    val error: String = ""
)