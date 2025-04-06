package app.what.gorogeuslugi.features.create_event.presentation.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateEvent
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateState
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun AppOutlinedTextField(
    value: String,
    placeholder: String,
    onEvent: (String) -> Unit,
) = OutlinedTextField(
    value = value,
    placeholder = {
        Text(
            placeholder,
            color = buttonBlack.copy(alpha = 0.5f),
            fontSize = 14.sp,
            lineHeight = 14.sp,
            fontWeight = FontWeight(600)
        )
    },
    onValueChange = { onEvent(it) },
    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
    shape = RoundedCornerShape(10.dp)
)

@Composable
fun RowScope.AppOutlinedTextField(
    value: String,
    placeholder: String,
    onEvent: (String) -> Unit,
) = OutlinedTextField(
    value = value,
    placeholder = {
        Text(
            placeholder,
            color = buttonBlack.copy(alpha = 0.5f),
            fontSize = 14.sp,
            lineHeight = 14.sp,
            fontWeight = FontWeight(600)
        )
    },
    onValueChange = { onEvent(it) },
    modifier = Modifier.weight(1f),
    shape = RoundedCornerShape(10.dp)
)
