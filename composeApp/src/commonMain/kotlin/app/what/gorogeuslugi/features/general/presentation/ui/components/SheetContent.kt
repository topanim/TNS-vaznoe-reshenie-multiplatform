package app.what.gorogeuslugi.features.general.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.features.general.presentation.models.GeneralEvents
import app.what.gorogeuslugi.features.general.presentation.models.GeneralState
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun SheetContents(state: GeneralState, listener: (GeneralEvents) -> Unit) {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Фильтры",
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            lineHeight = 20.sp,
            color = buttonBlack,
            textAlign = TextAlign.Center
        )
        Gap(10)
        HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
        Gap(10)
        FilterComponent(state.filterType) {
            listener(GeneralEvents.SelectFilter(it))
        }
    }
}