package com.umutcansahin.rickmorty.presentation.episode_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.rickmorty.common.Resource
import com.umutcansahin.rickmorty.domain.use_case.get_episodes.GetEpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EpisodeListViewModel @Inject constructor(
    private val getEpisodesUseCase: GetEpisodesUseCase
) : ViewModel(){

    private val _state = mutableStateOf(EpisodeListState())
    val state: State<EpisodeListState> = _state

    init {
        getEpisodes()
    }

    private fun getEpisodes() {
        getEpisodesUseCase().onEach { result->
            when(result) {
                is Resource.Success -> {
                    _state.value = EpisodeListState(episodes = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = EpisodeListState(error = result.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = EpisodeListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
