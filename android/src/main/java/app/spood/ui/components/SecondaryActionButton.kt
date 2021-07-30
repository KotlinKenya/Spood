package app.spood.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.spood.R
import app.spood.theme.green
import app.spood.theme.greyDark

@Preview(showBackground = true)
@Composable
fun SecondaryActionButtonPreview() {
    SecondaryActionButton(
        textPrimary = "Description",
        textSecondary = "Action",
        icon = R.drawable.ic_arrow_right
    )
}

@Composable
fun SecondaryActionButton(
    textPrimary: String = "",
    textSecondary: String = "",
    icon: Int? = null,
    action: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .clickable(onClick = action)
    ) {
        Text(
            text = textPrimary,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Light,
            color = greyDark
        )

        Spacer(Modifier.size(4.dp))

        Text(
            text = textSecondary,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.Light,
            color = green
        )

        Spacer(Modifier.size(4.dp))

        icon?.let {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Arrow",
                colorFilter = ColorFilter.tint(greyDark),
            )
        }
    }
}