package com.umutcansahin.rickmorty.domain.model.character_detail

import com.umutcansahin.rickmorty.data.remote.dto.character_detail.CharacterDetailLocationDto
import com.umutcansahin.rickmorty.data.remote.dto.character_detail.CharacterDetailOriginDto

data class CharacterDetail(
    val created: String?,
    val gender: String?,
    val image: String?,
    val location: CharacterDetailLocationDto?,
    val name: String?,
    val origin: CharacterDetailOriginDto?,
    val species: String?,
    val status: String?,
    val type: String?,
)
