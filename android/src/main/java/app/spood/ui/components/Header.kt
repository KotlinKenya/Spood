package app.spood.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.spood.theme.greenDark
import app.spood.theme.greyDark

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header(title = "Title", subTitle = "Subtitle")
}

@Composable
fun Header(
    title: String,
    subTitle: String
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .padding(vertical = 32.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            color = greenDark,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4
        )

        Spacer(Modifier.size(4.dp))

        Text(
            text = subTitle,
            color = greyDark,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Light
        )
    }
}