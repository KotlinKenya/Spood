package app.spood.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ErrorPreview() {
    ErrorMessage(error = "Error Message")
}

@Composable
fun ErrorMessage(error: String) {
    if (error.isNotBlank()) {
        Text(
            text = error,
            color = MaterialTheme.colors.error,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}