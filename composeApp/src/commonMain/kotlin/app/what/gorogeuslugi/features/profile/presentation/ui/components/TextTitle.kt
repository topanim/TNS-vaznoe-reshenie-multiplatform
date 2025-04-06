package app.what.gorogeuslugi.features.profile.presentation.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun TextTitle(text: String) {
    Text(
        text,
        modifier = Modifier.padding(start = 16.dp),
        color = buttonBlack,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        fontWeight = FontWeight(600)
    )
}