package com.umutcansahin.rickmorty.domain.repository

import com.umutcansahin.rickmorty.data.remote.dto.character.CharacterDto
import com.umutcansahin.rickmorty.data.remote.dto.character_detail.CharacterDetailDto
import com.umutcansahin.rickmorty.data.remote.dto.episode.EpisodeDto
import com.umutcansahin.rickmorty.data.remote.dto.episode_detail.EpisodeDetailDto

interface RickMortyRepository {

    suspend fun getEpisodes(): EpisodeDto

    suspend fun getEpisode(episodeId: String): EpisodeDetailDto

    suspend fun getCharacters(): CharacterDto

    suspend fun getCharacter(characterId: String): CharacterDetailDto

}