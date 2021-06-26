package app.spood

import android.util.Log
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
import app.spood.ui.theme.white
import app.spood.ui.theme.yellow

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen("Hello ")
}

@Composable
fun SplashScreen(message: String) {
    val goToAuthenticate: () -> Unit = {
        Log.e("SplashScreen", "Navigate to authentication")
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