package com.umutcansahin.rickmorty.data.remote.dto.character


import com.google.gson.annotations.SerializedName
import com.umutcansahin.rickmorty.domain.model.character.CharacterResult

data class CharacterResultDto(
    @SerializedName("created")
    val created: String?,
    @SerializedName("episode")
    val episode: List<String?>?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("location")
    val location: CharacterLocationDto?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin")
    val origin: CharacterOriginDto?,
    @SerializedName("species")
    val species: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

fun CharacterResultDto.toCharacterResult(): CharacterResult {
    return CharacterResult(
        image = image,
        name = name,
        status = status,
        id = id
    )
}