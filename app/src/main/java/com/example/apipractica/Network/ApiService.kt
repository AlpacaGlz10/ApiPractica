package com.example.apipractica.Network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = "e79edd42306836df0539a5afd73be446g"
    ): Response<MovieResponse>
}
