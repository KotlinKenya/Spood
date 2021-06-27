package app.spood.ui.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.spood.R
import app.spood.Screen
import app.spood.theme.white
import app.spood.theme.yellow
import app.spood.ui.components.Logo

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}

@Composable
fun SplashScreen(navController: NavHostController = rememberNavController()) {
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
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
        content = {
            Logo(paddingX = 128, modifier = Modifier.clickable(onClick = goToAuthenticate))

            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "Banner",
            )
            Image(
                painter = painterResource(id = R.drawable.tagline),
                contentDescription = "Tag line",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 56.dp)
            )
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