package com.example.apipractica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.apipractica.ui.theme.screen.MovieScreen
import com.example.apipractica.ui.theme.ApiPracticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApiPracticaTheme {
                MovieScreen()
            }
        }
    }
}