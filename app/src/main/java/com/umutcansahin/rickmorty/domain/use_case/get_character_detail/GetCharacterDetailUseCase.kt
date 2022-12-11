package com.umutcansahin.rickmorty.domain.use_case.get_character_detail

import com.umutcansahin.rickmorty.common.Resource
import com.umutcansahin.rickmorty.data.remote.dto.character_detail.toCharacterDetail
import com.umutcansahin.rickmorty.data.remote.dto.episode_detail.toEpisodeDetail
import com.umutcansahin.rickmorty.domain.model.character_detail.CharacterDetail
import com.umutcansahin.rickmorty.domain.model.episode_detail.EpisodeDetail
import com.umutcansahin.rickmorty.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
    operator fun invoke(characterId: String): Flow<Resource<CharacterDetail>> = flow {
        try {
            emit(Resource.Loading<CharacterDetail>())
            val episodeDetail = repository.getCharacter(characterId).toCharacterDetail()
            emit(Resource.Success<CharacterDetail>(episodeDetail))
        }catch (e: HttpException) {
            emit(Resource.Error<CharacterDetail>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException) {
            emit(Resource.Error<CharacterDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}