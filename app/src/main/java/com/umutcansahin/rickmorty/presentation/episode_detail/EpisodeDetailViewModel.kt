package com.umutcansahin.rickmorty.presentation.episode_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.rickmorty.common.Constants
import com.umutcansahin.rickmorty.common.Resource
import com.umutcansahin.rickmorty.domain.use_case.get_episode_detail.GetEpisodeDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val getEpisodeDetailUseCase: GetEpisodeDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(EpisodeDetailState())
    val state: State<EpisodeDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.EPISODE_ID)?.let { episodeId ->
            getEpisodeDetail(episodeId)
        }
    }

    private fun getEpisodeDetail(episodeId: String) {
        getEpisodeDetailUseCase(episodeId).onEach { episodeDetail->
            when(episodeDetail) {
                is Resource.Success -> {
                    _state.value = EpisodeDetailState(episodeDetail = episodeDetail.data)
                }
                is Resource.Error -> {
                    _state.value = EpisodeDetailState(error = episodeDetail.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = EpisodeDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}