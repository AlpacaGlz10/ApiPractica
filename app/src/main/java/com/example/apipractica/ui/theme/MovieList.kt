package com.example.apipractica.ui.theme

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apipractica.data.modelo.Movie
import com.example.apipractica.ui.theme.screen.MovieCard
import androidx.compose.ui.Modifier

@Composable
fun MovieList(movies: List<Movie>, navController: NavController) { // <-- Agregado navController
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(movies) { movie ->
            MovieCard(movie, navController) // <-- Pasamos el navController
        }
    }
}
