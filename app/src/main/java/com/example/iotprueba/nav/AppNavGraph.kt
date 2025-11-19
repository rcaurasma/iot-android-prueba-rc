package com.example.iotprueba.nav

import com.example.iotprueba.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.iotprueba.screens.HomeScreen
import com.example.iotprueba.screens.LoginScreen
import com.example.iotprueba.screens.RegisterScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavGraph() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = "splash") {
        composable("splash") {
            SplashScreen {
                nav.navigate(Route.Login.path) {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }
        composable(Route.Login.path) { LoginScreen(nav) }
        composable(Route.Register.path) { RegisterScreen(nav) }
        composable(Route.Home.path) { HomeScreen() }
    }
}

@Composable
fun SplashScreen(onFinish: () -> Unit) {
    // Composable minimal (logo centrado y fondo de marca)
    LaunchedEffect(Unit) {
        // Seguridad extra: si por alguna razón ya no mantiene el Splash nativo,
        // forzamos un fallback de 200-400ms para transicionar suave:
        delay(250L)
        onFinish()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo4), // <--- Aquí va el nombre sin el .png
            contentDescription = null, // O "Logo de la app"
            modifier = Modifier
                .size(128.dp)
                .align(Alignment.Center),
            tint = Color.Unspecified // Importante: Si tu logo tiene colores propios, usa Unspecified para que no lo pinte todo de un solo color
        )
    }
}
