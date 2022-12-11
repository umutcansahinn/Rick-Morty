package com.umutcansahin.rickmorty.data.remote.dto.episode


import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("info")
    val info: EpisodeInfoDto?,
    @SerializedName("results")
    val results: List<ResultDto?>?
)
/*
fun EpisodeDto.toResult(): CharacterResultDto {
    return CharacterResultDto(
        episode = results?.map { it?.episode },
        id = results?.map { it?.id },
        name = results?.map { it?.name },
    )
}
*/