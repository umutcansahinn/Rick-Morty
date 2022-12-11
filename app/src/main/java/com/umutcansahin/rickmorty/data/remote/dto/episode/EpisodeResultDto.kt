package com.umutcansahin.rickmorty.data.remote.dto.episode


import com.google.gson.annotations.SerializedName
import com.umutcansahin.rickmorty.domain.model.episode.EpisodeResult

data class ResultDto(
    @SerializedName("air_date")
    val airDate: String?,
    @SerializedName("characters")
    val characters: List<String?>?,
    @SerializedName("created")
    val created: String?,
    @SerializedName("episode")
    val episode: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)

fun ResultDto.toResult(): EpisodeResult {
    return EpisodeResult(
        episode = episode,
        id = id,
        name = name,
    )
}

