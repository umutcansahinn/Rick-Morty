package com.umutcansahin.rickmorty.presentation

sealed class Screen(val route: String) {
    object EpisodeListScreen: Screen("episode_list_screen")
    object EpisodeDetailScreen: Screen("episode_detail_screen")
    object CharacterListScreen: Screen("character_list_screen")
    object CharacterDetailScreen: Screen("character_detail_screen")

}