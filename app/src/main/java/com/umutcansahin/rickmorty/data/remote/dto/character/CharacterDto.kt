package com.umutcansahin.rickmorty.data.remote.dto.character


import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("info")
    val info: CharacterInfoDto?,
    @SerializedName("results")
    val results: List<CharacterResultDto?>?
)