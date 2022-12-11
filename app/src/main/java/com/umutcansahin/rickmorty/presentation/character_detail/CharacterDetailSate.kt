package com.umutcansahin.rickmorty.presentation.character_detail

import com.umutcansahin.rickmorty.domain.model.character_detail.CharacterDetail


data class CharacterDetailSate(
    val isLoading: Boolean = false,
    val characterDetail: CharacterDetail? = null,
    val error: String = ""
)