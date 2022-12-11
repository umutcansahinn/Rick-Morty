package com.umutcansahin.rickmorty.data.remote.dto.character


import com.google.gson.annotations.SerializedName

data class CharacterInfoDto(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("prev")
    val prev: Any?
)