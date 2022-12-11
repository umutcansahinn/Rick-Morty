package com.umutcansahin.rickmorty.domain.use_case.get_episode_detail

import com.umutcansahin.rickmorty.common.Resource
import com.umutcansahin.rickmorty.data.remote.dto.episode_detail.toEpisodeDetail
import com.umutcansahin.rickmorty.domain.model.episode_detail.EpisodeDetail
import com.umutcansahin.rickmorty.domain.repository.RickMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEpisodeDetailUseCase @Inject constructor(
private val repository: RickMortyRepository
) {
    operator fun invoke(episodeId: String): Flow<Resource<EpisodeDetail>> = flow {
        try {
            emit(Resource.Loading<EpisodeDetail>())
            val episodeDetail = repository.getEpisode(episodeId).toEpisodeDetail()
            emit(Resource.Success<EpisodeDetail>(episodeDetail))
        }catch (e: HttpException) {
            emit(Resource.Error<EpisodeDetail>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e: IOException) {
            emit(Resource.Error<EpisodeDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}