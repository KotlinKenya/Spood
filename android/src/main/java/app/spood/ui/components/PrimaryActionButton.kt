package app.spood.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
    ) {
        Button(
            onClick = { },
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = yellow,
                contentColor = greenDark
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(98.dp)
                .padding(vertical = 24.dp)
                .clickable(onClick = action)
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
        }
    }
}