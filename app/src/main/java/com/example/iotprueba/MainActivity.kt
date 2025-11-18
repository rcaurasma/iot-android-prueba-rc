package com.example.iotprueba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.iotprueba.nav.AppNavGraph
import com.example.iotprueba.ui.theme.IoTPruebaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IoTPruebaTheme { AppNavGraph() }
        }
    }
}