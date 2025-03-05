package com.example.apipractica.data.repository

import com.example.apipractica.Network.MovieResponse
import com.example.apipractica.Network.RetrofitClient
import retrofit2.Response

class MovieRepository {
    suspend fun getPopularMovies(): Response<MovieResponse> {
        return RetrofitClient.apiService.getPopularMovies()
    }
}
