package app.spood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import app.spood.theme.SpoodTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
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