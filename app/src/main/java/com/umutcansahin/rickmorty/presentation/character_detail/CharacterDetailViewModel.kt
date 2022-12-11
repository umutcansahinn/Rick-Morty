package com.umutcansahin.rickmorty.presentation.character_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.rickmorty.common.Constants
import com.umutcansahin.rickmorty.common.Resource
import com.umutcansahin.rickmorty.domain.use_case.get_character_detail.GetCharacterDetailUseCase
import com.umutcansahin.rickmorty.domain.use_case.get_episode_detail.GetEpisodeDetailUseCase
import com.umutcansahin.rickmorty.presentation.episode_detail.EpisodeDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: GetCharacterDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CharacterDetailSate())
    val state: State<CharacterDetailSate> = _state

    init {
        savedStateHandle.get<String>(Constants.CHARACTER_ID)?.let { characterId ->
            getCharacterDetail(characterId)
        }
    }

    private fun getCharacterDetail(characterId: String) {
        getCharacterDetailUseCase(characterId).onEach { characterDetail->
            when(characterDetail) {
                is Resource.Success -> {
                    _state.value = CharacterDetailSate(characterDetail = characterDetail.data)
                }
                is Resource.Error -> {
                    _state.value = CharacterDetailSate(error = characterDetail.message ?: "An unexpected error occured")
                }
                is Resource.Loading -> {
                    _state.value = CharacterDetailSate(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}