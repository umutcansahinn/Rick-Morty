package com.umutcansahin.rickmorty.domain.use_case.get_characters

import com.umutcansahin.rickmorty.common.Resource
import com.umutcansahin.rickmorty.data.remote.dto.character.toCharacterResult
import com.umutcansahin.rickmorty.data.remote.dto.episode.toResult
import com.umutcansahin.rickmorty.domain.model.character.CharacterResult
import com.umutcansahin.rickmorty.domain.model.episode.EpisodeResult
import com.umutcansahin.rickmorty.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
    operator fun invoke(): Flow<Resource<List<CharacterResult?>?>> = flow {
        try {
            emit(Resource.Loading<List<CharacterResult?>?>())
            val results = repository.getCharacters().results?.map {
                it?.toCharacterResult()
            }
            emit(Resource.Success<List<CharacterResult?>?>(results))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CharacterResult?>?>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<CharacterResult?>?>("Couldn't reach server. Check your internet connection."))
        }
    }
}