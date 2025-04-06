package app.what.gorogeuslugi.features.general.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.what.gorogeuslugi.components.CustomButton
import app.what.gorogeuslugi.features.general.presentation.models.TimeEvent
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.theme.buttonBlack


@Composable
fun TimeFilterRow(
    selectedFilter: TimeEvent,
    select: (TimeEvent) -> Unit
) = Row(
    modifier = Modifier.fillMaxWidth()
        .padding(horizontal = 16.dp),
    verticalAlignment = Alignment.CenterVertically,
) {

    CustomButton(
        title = "Текущие",
        modifier = Modifier
            .weight(1f)
            .height(40.dp),
        color = if (selectedFilter == TimeEvent.CURRENT) buttonBlack else Color.White,
        textColor = if (selectedFilter == TimeEvent.CURRENT) Color.White else buttonBlack,
    ) {
        select(TimeEvent.CURRENT)
    }
    Gap(20)
    CustomButton(
        title = "Прошедшие",
        modifier = Modifier
            .weight(1f)
            .height(40.dp),
        color = if (selectedFilter == TimeEvent.PAST) buttonBlack else Color.White,
        textColor = if (selectedFilter == TimeEvent.PAST) Color.White else buttonBlack
    ) {
        select(TimeEvent.PAST)
    }
}

