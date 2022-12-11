package com.umutcansahin.rickmorty.data.remote.dto.character_detail


import com.google.gson.annotations.SerializedName
import com.umutcansahin.rickmorty.domain.model.character_detail.CharacterDetail

data class CharacterDetailDto(
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
    val location: CharacterDetailLocationDto?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("origin")
    val origin: CharacterDetailOriginDto?,
    @SerializedName("species")
    val species: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("url")
    val url: String?
)

fun CharacterDetailDto.toCharacterDetail(): CharacterDetail {
    return CharacterDetail(
        created = created,
        gender = gender,
        image = image,
        location = location,
        name = name,
        origin = origin,
        species = species,
        status = status,
        type = type
    )
}