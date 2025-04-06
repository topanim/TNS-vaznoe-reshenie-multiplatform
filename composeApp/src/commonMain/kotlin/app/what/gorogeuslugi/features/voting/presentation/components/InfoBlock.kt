package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun InfoBlock() = Column(
    modifier = Modifier.fillMaxWidth()
) {
    Text(
        "Информация о голосовании",
        fontSize = 20.sp,
        fontWeight = FontWeight(700),
        lineHeight = 20.sp,
        color = buttonBlack
    )

    Gap(10)

}