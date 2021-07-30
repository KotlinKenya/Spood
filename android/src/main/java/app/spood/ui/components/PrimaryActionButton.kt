package app.spood.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.spood.theme.greenDark
import app.spood.theme.yellow

@Preview(showBackground = true)
@Composable
fun PrimaryActionButtonPreview() {
    PrimaryActionButton("Description")
}

@Composable
fun PrimaryActionButton(text: String = "", action: () -> Unit = {}) {
    Button(
        onClick = action,
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = yellow,
            contentColor = greenDark
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
    }
}