package app.spood

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.spood.ui.signUp.SignUp
import app.spood.ui.splashScreen.SplashScreen

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splashscreen")
    object SignUp : Screen("signUp")
}

@Composable
fun SpoodNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) { SplashScreen(navController) }
        composable(Screen.SignUp.route) { SignUp(navController) }
    }
}