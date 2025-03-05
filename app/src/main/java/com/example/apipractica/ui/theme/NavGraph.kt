package com.example.apipractica.ui.theme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import com.example.apipractica.ui.theme.screen.MovieScreen
import com.example.apipractica.ui.theme.screen.MovieDetailScreen  // <--- IMPORTANTE
import com.example.apipractica.data.modelo.Movie

sealed class Screen(val route: String) {
    object MovieList : Screen("movie_list")
    object MovieDetail : Screen("movie_detail/{movieId}") {
        fun createRoute(movieId: Int) = "movie_detail/$movieId"
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MovieList.route
    ) {
        composable(Screen.MovieList.route) {
            MovieScreen(navController = navController)
        }

        composable(
            route = Screen.MovieDetail.route,
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            movieId?.let { id ->
                val sampleMovie = Movie(
                    id = id,
                    title = "Título de prueba",
                    overview = "Descripción de prueba",
                    posterPath = "/imagen.jpg"
                )
                MovieDetailScreen(movie = sampleMovie, navController = navController)
            }
        }
    }
}
