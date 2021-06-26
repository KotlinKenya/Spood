package app.spood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import app.spood.ui.theme.SpoodTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpoodTheme {
                val navController = rememberNavController()
                Scaffold(
                    content = { SpoodNavigation(navController) }
                )
            }
        }
    }
}