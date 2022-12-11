package com.umutcansahin.rickmorty.presentation.episode_detail

import com.umutcansahin.rickmorty.domain.model.episode_detail.EpisodeDetail

data class EpisodeDetailState(
    val isLoading: Boolean = false,
    val episodeDetail: EpisodeDetail? = null,
    val error: String = ""
)