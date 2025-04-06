package app.what.gorogeuslugi.features.profile.presentation.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun ProfileWidget(text: String) = Text(
    text,
    modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .border(1.dp, Color(0xFFDBDBDB), RoundedCornerShape(10.dp))
        .padding(16.dp),
    color = buttonBlack,
    fontSize = 14.sp,
    lineHeight = 14.sp,
    fontWeight = FontWeight(600)
)
