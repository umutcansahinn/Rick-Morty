package com.umutcansahin.rickmorty.domain.model.episode_detail

import com.google.gson.annotations.SerializedName

data class EpisodeDetail(
    val airDate: String?,
    val characters: List<String?>?,
    val created: String?,
    val episode: String?,
    val name: String?,
)
