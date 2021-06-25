package app.spood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import app.spood.ui.theme.SpoodTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpoodTheme {
                Scaffold(
                    content = {SplashScreen(greet())}
                )
            }
        }
    }

    private fun greet(): String {
        return Greeting().greeting()
    }
}