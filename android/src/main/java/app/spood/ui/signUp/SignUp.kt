package app.spood.ui.signUp

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignUp(rememberNavController())
}

@Composable
fun SignUp(navController: NavHostController) {

    Scaffold(
        content = { Text("Sign Up") },
    )
}