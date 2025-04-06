package app.what.gorogeuslugi.features.create_event.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.components.HeaderWidget
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateEvent
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateState
import app.what.gorogeuslugi.features.create_event.presentation.ui.components.AppButton
import app.what.gorogeuslugi.features.create_event.presentation.ui.components.AppOutlinedTextField
import app.what.gorogeuslugi.features.profile.presentation.ui.components.TitleWidget
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.theme.baseDark
import app.what.gorogeuslugi.theme.buttonBlack
import app.what.gorogeuslugi.theme.buttonGreen
import app.what.gorogeuslugi.theme.buttonLight

@Composable
fun CreateView(state: CreateState, listener: Listener<CreateEvent>) = Box {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .systemBarsPadding()
    ) {
        HeaderWidget("Создание голосования") { listener(CreateEvent.OnBack) }
        TitleWidget(Icons.Default.AccountBox, "Заполните описание голосования:")
        Gap(16)
        Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            AppOutlinedTextField(
                value = state.dateStart,
                placeholder = "Дата начала",
                onEvent = { listener(CreateEvent.SetDateStart(it)) }
            )
            Gap(16)
            AppOutlinedTextField(
                value = state.dateEnd,
                placeholder = "Дата окончания",
                onEvent = { listener(CreateEvent.SetDateEnd(it)) }
            )
        }
        Gap(16)
        AppOutlinedTextField(
            value = state.agenda,
            placeholder = "Повестка дня",
            onEvent = { listener(CreateEvent.SetAgenda(it)) }
        )
        Gap(16)
        AppOutlinedTextField(
            value = state.description,
            placeholder = "Заполните полную информацию о мероприятии",
            onEvent = { listener(CreateEvent.SetDescription(it)) }
        )
        Gap(16)
        AppOutlinedTextField(
            value = state.board,
            placeholder = "Выберете комитет",
            onEvent = { listener(CreateEvent.SetBoard(it)) }
        )
        Gap(16)
        AppOutlinedTextField(
            value = state.format,
            placeholder = "Выберете формат проведения",
            onEvent = { listener(CreateEvent.SetFormat(it)) }
        )
        Gap(16)
        Text(
            "Ссылка на конференцию",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = buttonGreen,
            fontSize = 14.sp,
            lineHeight = 14.sp,
        )
        Gap(4)
        AppOutlinedTextField(
            value = state.link,
            placeholder = "Ссылка на мероприятие",
            onEvent = { listener(CreateEvent.SetLink(it)) }
        )
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .align(Alignment.BottomCenter)
            .systemBarsPadding()
    ) {
        AppButton(
            isSave = false,
            onClick = { listener(CreateEvent.OnBack) }
        )
        Gap(16)
        AppButton(
            isSave = true,
            onClick = { listener(CreateEvent.OnSave) }
        )
    }
}