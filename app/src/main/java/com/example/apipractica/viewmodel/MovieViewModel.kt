package com.example.apipractica.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.apipractica.data.modelo.Movie
import com.example.apipractica.data.repository.MovieRepository
import java.io.IOException

class MovieViewModel : ViewModel() {
    private val repository = MovieRepository()

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _errorMessage.value = null
                val response = repository.getPopularMovies()

                if (response.isSuccessful) {
                    _movies.value = response.body()?.movies ?: emptyList()
                } else {
                    _errorMessage.value = "Error en la API: ${response.code()} ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error de conexión: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

}
