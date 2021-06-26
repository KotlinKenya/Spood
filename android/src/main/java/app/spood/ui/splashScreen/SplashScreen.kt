package app.spood.ui.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.spood.R
import app.spood.Screen
import app.spood.ui.theme.white
import app.spood.ui.theme.yellow

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}

@Composable
fun SplashScreen(navController: NavHostController) {
    val goToAuthenticate: () -> Unit = {
        navController.navigate(Screen.SignUp.route) {
            popUpTo(navController.graph.findStartDestination().id) { inclusive = true }
        }
    }

    Scaffold(
        backgroundColor = yellow,
        content = { Content(goToAuthenticate) },
        floatingActionButton = { FloatingButton(goToAuthenticate) }
    )
}

@Composable
fun Content(goToAuthenticate: () -> Unit, modifier: Modifier = Modifier) {
    val logo = painterResource(id = R.drawable.logo)
    val banner = painterResource(id = R.drawable.banner)
    val tagline = painterResource(id = R.drawable.tagline)
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
        content = {
            Image(
                painter = logo,
                contentDescription = "Logo",
                modifier = Modifier.clickable(onClick = goToAuthenticate)
            )
            Image(painter = banner, contentDescription = "Banner")
            Image(painter = tagline, contentDescription = "Tag line")
        }
    )
}

@Composable
fun FloatingButton(goToAuthenticate: () -> Unit) {
    val arrowRight = painterResource(id = R.drawable.ic_arrow_right)
    FloatingActionButton(
        backgroundColor = white,
        onClick = goToAuthenticate,
        content = { Image(painter = arrowRight, contentDescription = "Arrow Right") }
    )
}