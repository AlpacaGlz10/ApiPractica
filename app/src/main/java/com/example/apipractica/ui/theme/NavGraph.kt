package com.example.apipractica.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.apipractica.ui.theme.screen.MovieScreen
import androidx.navigation.NavHostController
import com.example.apipractica.data.modelo.Movie

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
    object MovieDetail : Screen("movie_detail/{movieId}") {
        fun createRoute(movieId: Int) = "movie_detail/$movieId"
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.MovieList.route) {
        composable(Screen.MovieList.route) {
            MovieScreen(navController)
        }
        composable(Screen.MovieDetail.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull()
            movieId?.let { id ->
                // Aquí deberías obtener la película desde ViewModel o un Repository
                // Por ahora, simplemente pasaremos una película de prueba
                val sampleMovie = Movie(id, "Título de prueba", "Descripción de prueba", "/imagen.jpg")
                MovieDetailScreen(movie = sampleMovie, navController = navController)
            }
        }
    }
}