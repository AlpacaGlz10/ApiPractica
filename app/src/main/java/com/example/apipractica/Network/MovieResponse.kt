package com.example.apipractica.Network

import com.example.apipractica.data.modelo.Movie
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val movies: List<Movie>
)
