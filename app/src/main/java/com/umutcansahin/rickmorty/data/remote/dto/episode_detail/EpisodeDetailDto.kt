package com.umutcansahin.rickmorty.data.remote.dto.episode_detail


import com.google.gson.annotations.SerializedName
import com.umutcansahin.rickmorty.domain.model.episode_detail.EpisodeDetail

data class EpisodeDetailDto(
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

fun EpisodeDetailDto.toEpisodeDetail(): EpisodeDetail {
    return EpisodeDetail(
        airDate = airDate,
        characters = characters,
        created = created,
        episode = episode,
        name = name
    )
}