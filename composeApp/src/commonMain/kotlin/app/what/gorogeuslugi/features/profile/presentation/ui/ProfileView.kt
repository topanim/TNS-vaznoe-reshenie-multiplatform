package app.what.gorogeuslugi.features.profile.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.what.gorogeuslugi.components.HeaderWidget
import app.what.gorogeuslugi.features.profile.presentation.models.ProfileEvent
import app.what.gorogeuslugi.features.profile.presentation.models.ProfileState
import app.what.gorogeuslugi.features.profile.presentation.ui.components.ProfileWidget
import app.what.gorogeuslugi.features.profile.presentation.ui.components.TextTitle
import app.what.gorogeuslugi.features.profile.presentation.ui.components.TitleWidget
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.foundation.ui.Gap

@Composable
fun ProfileView(state: ProfileState, listener: Listener<ProfileEvent>) = Column(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .systemBarsPadding()
) {
    HeaderWidget("Профиль")
    HorizontalDivider(Modifier.padding(horizontal = 16.dp))
    Gap(16)
    if (state.user != null) {
        TitleWidget(Icons.Default.AccountBox, "Аккаунт")
        Gap(16)
        TextTitle("ФИО")
        Gap(4)
        ProfileWidget(state.user.name ?: "")
        Gap(16)
        TextTitle("Должность")
        Gap(4)
        ProfileWidget(state.user.position)
        Gap(16)
        TextTitle("Комитет")
        Gap(4)
        ProfileWidget(state.user.workplace)
        Gap(16)
        TextTitle("Серия и номер паспорта")
        Gap(4)
        ProfileWidget(state.user.passportSeriesNumber)
        Gap(16)
        TextTitle("Данные паспорта")
        Gap(4)
        ProfileWidget(state.user.passportData)
        Gap(16)
        TextTitle("Номер телефона")
        Gap(4)
        ProfileWidget(state.user.phone)
        Gap(16)
        TextTitle("Адресс")
        Gap(4)
        ProfileWidget(state.user.address)
        Gap(16)
        TextTitle("Электронная почта")
        Gap(4)
        ProfileWidget(state.user.email)
        Gap(16)
        TextTitle("Логин")
        Gap(4)
        ProfileWidget(state.user.login)
        Gap(16)


        TitleWidget(Icons.Default.Settings, "Общие настройки")
    }
}