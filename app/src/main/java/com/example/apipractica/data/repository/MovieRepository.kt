package com.example.apipractica.data.repository

import com.example.apipractica.Network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository {
    suspend fun getPopularMovies() = withContext(Dispatchers.IO) {
        RetrofitClient.apiService.getPopularMovies()
    }
}