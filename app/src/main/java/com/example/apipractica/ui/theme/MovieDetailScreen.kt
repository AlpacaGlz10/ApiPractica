package com.example.apipractica.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.apipractica.data.modelo.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailScreen(movie: Movie, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(movie.title) })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            Image(
                painter = rememberImagePainter("https://image.tmdb.org/t/p/w500${movie.imageUrl}"),
                contentDescription = movie.title,
                modifier = Modifier.fillMaxWidth().height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = movie.title, modifier = Modifier.padding(16.dp))
            Text(text = movie.description, modifier = Modifier.padding(16.dp))
        }
    }
}