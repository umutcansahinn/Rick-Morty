package com.umutcansahin.rickmorty.domain.model.episode
/*
data class CharacterResultDto(
    val episode: List<String?>?,
    val id: List<Int?>?,
    val name: List<String?>?
)
*/
data class EpisodeResult(
    val episode: String?,
    val id: Int?,
    val name: String?
)