package com.example.apipractica.data.remoto

import  com.example.apipractica.data.modelo.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi  {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): MovieResponse
}

data class MovieResponse(
    val results: List<Movie>
)
