package com.umutcansahin.rickmorty.data.remote

import com.umutcansahin.rickmorty.data.remote.dto.character.CharacterDto
import com.umutcansahin.rickmorty.data.remote.dto.character_detail.CharacterDetailDto
import com.umutcansahin.rickmorty.data.remote.dto.episode.EpisodeDto
import com.umutcansahin.rickmorty.data.remote.dto.episode_detail.EpisodeDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface RickMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodeDto

    @GET("episode/{episodeId}")
    suspend fun getEpisode(@Path("episodeId") episodeId: String): EpisodeDetailDto

    @GET("character")
    suspend fun getCharacters(): CharacterDto

    @GET("character/{characterId}")
    suspend fun getCharacter(@Path("characterId") characterId: String): CharacterDetailDto

}