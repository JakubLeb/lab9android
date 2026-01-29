package pbs.edu.lab91.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import pbs.edu.lab91.navigation.MovieScreens
import pbs.edu.lab91.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies TopAppBar Wykład") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Blue,
                tonalElevation = 9.dp
            ) {
                Text(
                    text = "Movies bottomBar Wykład",
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            MainContent(navController = navController)
        }
    }
}
@Composable
fun MainContent(navController: NavController) {
    val moviesList = listOf(
        "Avatarc",
        "555",
        "Harry PotterX",
        "Life",
        "Lolek",
        "Bolek",
        "Krecik",
        "Idą Święta",
        "Wykład"
    )
    Column {
        LazyColumn {
            items(items = moviesList) { movie ->
                MovieRow(movie = movie) { movieName ->
                    navController.navigate(
                        route =
                            MovieScreens.DetailsScreen.name + "/$movieName"
                    )
                    Log.d("TAG", "MainContent:$movieName")
                }
            }
        }
    }
}