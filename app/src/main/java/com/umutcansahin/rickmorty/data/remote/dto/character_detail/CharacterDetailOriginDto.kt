package com.umutcansahin.rickmorty.data.remote.dto.character_detail


import com.google.gson.annotations.SerializedName

data class CharacterDetailOriginDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)