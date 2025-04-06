package app.what.gorogeuslugi.features.create_event.presentation.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.theme.buttonBlack
import app.what.gorogeuslugi.theme.buttonLight

@Composable
fun RowScope.AppButton(
    isSave: Boolean,
    onClick: () -> Unit,
) = Button(
    modifier = Modifier.weight(1f),
    shape = RoundedCornerShape(10.dp),
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
        containerColor = if (isSave) buttonBlack else buttonLight,
    )
) {
    Text(
        if (isSave) "Сохранить" else "Отменить",
        modifier = Modifier.padding(horizontal = 16.dp),
        color = if (isSave) buttonLight else buttonBlack,
        fontSize = 14.sp,
        lineHeight = 14.sp,
    )
}
