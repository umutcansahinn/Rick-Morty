package com.umutcansahin.rickmorty.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.umutcansahin.rickmorty.presentation.episode_detail.EpisodeDetailScreen
import com.umutcansahin.rickmorty.presentation.episode_list.EpisodeListScreen
import com.umutcansahin.rickmorty.presentation.ui.theme.RickMortyTheme
import com.umutcansahin.rickmorty.R
import com.umutcansahin.rickmorty.presentation.character_detail.CharacterDetailScreen
import com.umutcansahin.rickmorty.presentation.character_list.CharacterListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickMortyTheme {

                val bottomBarState = remember { mutableStateOf(Screen.EpisodeListScreen.route) }

                val navController = rememberNavController()

                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "Rick&Morty") },
                                backgroundColor = Color.LightGray,
                                contentColor = Color.Black
                            )
                        },
                        content = {

                            NavHost(
                                navController = navController,
                                startDestination = bottomBarState.value
                            ) {

                                composable(Screen.EpisodeListScreen.route) {
                                    EpisodeListScreen(navController = navController)
                                }
                                composable(Screen.EpisodeDetailScreen.route + "/{episodeId}") {
                                    EpisodeDetailScreen()
                                }
                                composable(Screen.CharacterListScreen.route) {
                                    CharacterListScreen(navController = navController)
                                }
                                composable(Screen.CharacterDetailScreen.route + "/{characterId}") {
                                    CharacterDetailScreen()
                                }
                            }

                        },
                        bottomBar = {
                            BottomAppBar(
                                backgroundColor = MaterialTheme.colors.background,
                                content = {
                                    BottomNavigationItem(
                                        selected = bottomBarState.value == Screen.EpisodeListScreen.route,
                                        onClick = {
                                            bottomBarState.value = Screen.EpisodeListScreen.route
                                        },
                                        icon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.list_image),
                                                contentDescription = ""
                                            )
                                        },
                                        label = { Text(text = "Episodes") },
                                        selectedContentColor = Color.Black,
                                        unselectedContentColor = Color.Gray
                                    )
                                    BottomNavigationItem(
                                        selected = bottomBarState.value == Screen.CharacterListScreen.route,
                                        onClick = {
                                            bottomBarState.value = Screen.CharacterListScreen.route
                                        },
                                        icon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.person_image),
                                                contentDescription = ""
                                            )
                                        },
                                        label = { Text(text = "Characters") },
                                        selectedContentColor = Color.Black,
                                        unselectedContentColor = Color.Gray
                                    )
                                }
                            )
                        }
                    )
                }
            }
        }
    }
}
