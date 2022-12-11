package com.umutcansahin.rickmorty.data.repository

import com.umutcansahin.rickmorty.data.remote.RickMortyApi
import com.umutcansahin.rickmorty.data.remote.dto.character.CharacterDto
import com.umutcansahin.rickmorty.data.remote.dto.character_detail.CharacterDetailDto
import com.umutcansahin.rickmorty.data.remote.dto.episode.EpisodeDto
import com.umutcansahin.rickmorty.data.remote.dto.episode_detail.EpisodeDetailDto
import com.umutcansahin.rickmorty.domain.repository.RickMortyRepository
import javax.inject.Inject

class RickMortyRepositoryImpl @Inject constructor(
    private val api: RickMortyApi
) : RickMortyRepository {

    override suspend fun getEpisodes(): EpisodeDto {
        return api.getEpisodes()
    }

    override suspend fun getEpisode(episodeId: String): EpisodeDetailDto {
        return api.getEpisode(episodeId)
    }

    override suspend fun getCharacters(): CharacterDto {
        return api.getCharacters()
    }

    override suspend fun getCharacter(characterId: String): CharacterDetailDto {
        return api.getCharacter(characterId)
    }
}