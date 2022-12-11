package com.umutcansahin.rickmorty.data.remote.dto.episode


import com.google.gson.annotations.SerializedName

data class EpisodeInfoDto(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("prev")
    val prev: Any?
)




