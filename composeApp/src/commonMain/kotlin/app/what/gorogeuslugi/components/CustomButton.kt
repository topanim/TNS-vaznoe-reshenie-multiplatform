package app.what.gorogeuslugi.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.theme.baseWhite
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun CustomButton(
    title: String,
    color: Color = buttonBlack,
    textColor: Color = baseWhite,
    modifier: Modifier,
    action: () -> Unit
) {
    Button(
        onClick = { action() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
        ),
        modifier = modifier,
        border = BorderStroke(
            width = 1.dp,
            color = Color(0xFFDBDBDB)
        )
    ) {
        Text(
            title,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}
