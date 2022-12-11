package com.umutcansahin.rickmorty.data.remote.dto.character


import com.google.gson.annotations.SerializedName

data class CharacterLocationDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)