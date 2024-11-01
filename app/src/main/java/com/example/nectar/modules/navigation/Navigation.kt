package com.example.nectar.modules.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.modules.login.LoginScreen
import com.example.nectar.modules.splash.SplashScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun NavigationRoot() {
    // Nav host Composable
    val navController = rememberNavController()

    //Nav graph
    NavHost(navController = navController, startDestination = ScreenRoot.SplashScreen.router){
        composable(ScreenRoot.SplashScreen.router) {

            LaunchedEffect(key1 = null) {
                delay(3.seconds)
                navController.popBackStack()
                navController.navigate(ScreenRoot.LoginScreen.router)
            }
            SplashScreen()
        }
        composable(ScreenRoot.LoginScreen.router) {
            LoginScreen()
        }
    }
}

sealed class ScreenRoot(val router: String){
    object SplashScreen: ScreenRoot("splash")
    object LoginScreen: ScreenRoot("login")

}