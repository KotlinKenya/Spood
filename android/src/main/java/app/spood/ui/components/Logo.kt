package app.spood.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import app.spood.R
import app.spood.theme.green

@Preview(showBackground = true)
@Composable
fun Logo1Preview() {
    Logo(paddingX = 128)
}

@Preview(showBackground = true)
@Composable
fun Logo2Preview() {
    Logo(tint = green, width = 72)
}

@Composable
fun Logo(
    modifier: Modifier = Modifier,
    tint: Color? = null,
    width: Int = Constraints.Infinity,
    paddingX: Int = 0
) {
    Box(modifier = Modifier.width(width.dp)) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            contentScale = ContentScale.FillWidth,
            colorFilter = tint?.let { ColorFilter.tint(it) },
            modifier = modifier.padding(horizontal = paddingX.dp)
        )
    }
}