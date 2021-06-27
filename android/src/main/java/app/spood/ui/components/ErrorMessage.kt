package app.spood.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun ErrorPreview() {
    ErrorMessage(error = "Error Message")
}

@Composable
fun ErrorMessage(error: String) {
    Text(text = error, color = MaterialTheme.colors.error)
}