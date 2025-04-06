package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.foundation.ui.Show
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun InfoBlock(
    icon: ImageVector,
    text: String
) = Row(
    modifier = Modifier.fillMaxWidth()
) {
    icon.Show(Modifier.size(24.dp))

    Gap(10)

    Text(text, color = buttonBlack)
}

@Composable
fun InfoBlock(
    icon: ImageVector,
    text: AnnotatedString
) = Column(
    modifier = Modifier.fillMaxWidth()
) {
    icon.Show(Modifier.size(24.dp))
    Gap(10)
    Text(text, color = buttonBlack)
}