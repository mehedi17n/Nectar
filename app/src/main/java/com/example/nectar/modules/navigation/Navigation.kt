package com.example.nectar.modules.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nectar.modules.login.LoginScreen
import com.example.nectar.modules.login.PhoneLoginScreen
import com.example.nectar.modules.onboarding.OnboardingScreen
import com.example.nectar.modules.splash.SplashScreen
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun NavigationRoot() {
    // Nav host Composable
    val navController = rememberNavController()

    // Nav graph
    NavHost(navController = navController, startDestination = ScreenRoot.SplashScreen.router) {
        composable(ScreenRoot.SplashScreen.router) {
            // LaunchedEffect to navigate after a delay
            LaunchedEffect(Unit) {
                delay(3.seconds)
                navController.navigate(ScreenRoot.OnboardingScreen.router) {
                    // This ensures that the splash screen is removed from the back stack
                    popUpTo(ScreenRoot.SplashScreen.router) { inclusive = true }
                }
            }
            SplashScreen() // Display the splash screen
        }

        composable(ScreenRoot.OnboardingScreen.router) {
            OnboardingScreen(navController) // Pass navController to the OnboardingScreen
        }

        composable(ScreenRoot.LoginScreen.router) {
            LoginScreen(navController) // Display the login screen
        }

        composable(ScreenRoot.PhoneLoginScreen.router) {
            PhoneLoginScreen(navController) // Display the login screen
        }
    }
}

// Define the navigation routes
sealed class ScreenRoot(val router: String) {
    object SplashScreen : ScreenRoot("splash")
    object LoginScreen : ScreenRoot("login")
    object OnboardingScreen : ScreenRoot("onboarding")
    object PhoneLoginScreen : ScreenRoot("phonelogin")
}