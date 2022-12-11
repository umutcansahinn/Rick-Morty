package com.umutcansahin.rickmorty.presentation.character_list

import com.umutcansahin.rickmorty.domain.model.character.CharacterResult
import com.umutcansahin.rickmorty.domain.model.episode.EpisodeResult

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<CharacterResult?>? = emptyList(),
    val error: String = ""
)