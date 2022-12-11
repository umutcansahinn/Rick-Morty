package com.umutcansahin.rickmorty.domain.use_case.get_episodes

import com.umutcansahin.rickmorty.common.Resource
import com.umutcansahin.rickmorty.data.remote.dto.episode.toResult
import com.umutcansahin.rickmorty.domain.model.episode.EpisodeResult
import com.umutcansahin.rickmorty.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEpisodesUseCase @Inject constructor(
    private val repository: RickMortyRepository
) {
 operator fun invoke(): Flow<Resource<List<EpisodeResult?>?>> = flow {
     try {
         emit(Resource.Loading<List<EpisodeResult?>?>())
         val results = repository.getEpisodes().results?.map {
             it?.toResult()
         }
         emit(Resource.Success<List<EpisodeResult?>?>(results))
     } catch (e: HttpException) {
         emit(Resource.Error<List<EpisodeResult?>?>(e.localizedMessage ?: "An unexpected error occured"))
     } catch (e: IOException) {
         emit(Resource.Error<List<EpisodeResult?>?>("Couldn't reach server. Check your internet connection."))
     }
 }
}