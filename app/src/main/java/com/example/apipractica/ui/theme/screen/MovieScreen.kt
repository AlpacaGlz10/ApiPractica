package com.example.apipractica.ui.theme.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.apipractica.viewmodel.MovieViewModel
import androidx.navigation.NavController
import com.example.apipractica.ui.theme.MovieList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(navController: NavController, viewModel: MovieViewModel = viewModel()) { // <-- Agregado navController
    val movies by viewModel.movies.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    // Ejecutar fetchMovies() al abrir la pantalla
    LaunchedEffect(Unit) {
        viewModel.fetchMovies()
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Películas Populares") }) }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when {
                isLoading -> CircularProgressIndicator(modifier = Modifier.fillMaxSize())
                errorMessage != null -> Text(text = errorMessage!!, modifier = Modifier.padding(16.dp))
                else -> MovieList(movies, navController) // <-- Pasamos el navController
            }
        }
    }
}
