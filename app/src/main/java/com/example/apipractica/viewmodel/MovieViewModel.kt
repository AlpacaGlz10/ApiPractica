package com.example.apipractica.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apipractica.data.modelo.Movie
import com.example.apipractica.Network.RetrofitClient
import com.example.apipractica.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            _isLoading.value = true
            val response = repository.getPopularMovies()
            if (response.isSuccessful) {
                _movies.value = response.body()?.movies ?: emptyList()
            } else {
                _errorMessage.value = "Error: ${response.message()}"
            }
            _isLoading.value = false
        }
    }
}