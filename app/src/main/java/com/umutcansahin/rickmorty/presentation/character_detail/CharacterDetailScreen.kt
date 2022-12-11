package com.umutcansahin.rickmorty.presentation.character_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.umutcansahin.rickmorty.presentation.character_detail.components.CharacterDetailImageItem
import com.umutcansahin.rickmorty.presentation.character_detail.components.CharacterDetailTextItem

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    
    Box(modifier = Modifier.fillMaxSize()) {
        state.characterDetail?.let { characterDetail ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item { 
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CharacterDetailImageItem(image = characterDetail.image)
                        CharacterDetailTextItem(text = characterDetail.name)
                        CharacterDetailTextItem(text = characterDetail.status)
                        CharacterDetailTextItem(text = characterDetail.species)
                        CharacterDetailTextItem(text = characterDetail.gender)
                        CharacterDetailTextItem(text = characterDetail.created)
                        CharacterDetailTextItem(text = characterDetail.type)
                        CharacterDetailTextItem(text = characterDetail.location?.name)
                        CharacterDetailTextItem(text = characterDetail.origin?.name)

                    }
                }

            }
        }
    }
    
}