package app.what.gorogeuslugi.features.onboarding.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.components.CustomButton
import app.what.gorogeuslugi.components.CustomTextField
import app.what.gorogeuslugi.components.HeaderWidget
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingEvents
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingState
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.navigation.core.rememberSheetController
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun LoginPage(state: OnboardingState, listener: Listener<OnboardingEvents>, onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
            .systemBarsPadding()
            .background(Color.White)
    ) {
        Box(modifier = Modifier.padding(horizontal = 9.dp)) {
            HeaderWidget(
                title = "Авторизация"
            ) {
                onBack()
            }
        }

        Text(
            "Для входа в приложение введите логин и пароль. Вам будет выслан код подтверждения:",
            fontSize = 14.sp,
            lineHeight = 14.sp,
            color = buttonBlack,
            fontWeight = FontWeight(600),
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(horizontal = 16.dp),
            textAlign = TextAlign.Start
        )
        Gap(15)
        CustomTextField(
            placeholder = "Логин",
            fieldColor = Color.White,
            leadingImage = null,
            inputText = {
                listener(OnboardingEvents.LoginText(it))
            }
        ) {

        }

        Gap(10)
        CustomTextField(
            placeholder = "Пароль",
            fieldColor = Color.White,
            leadingImage = null,
            inputText = {
                listener(OnboardingEvents.PasswordText(it))
            },
            trailingImage = if (state.isPasswordVisible) BaselineVisibilityOff24 else BaselineVisibility24
        ) {
            listener(OnboardingEvents.HidePassword)
        }

        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            title = "Войти",
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            listener(OnboardingEvents.ShowAlert)
        }
        Gap(40)
        if (state.showAlertDialog) {
            CustomAlertDialog(
                listener,
                onClose = {
                    listener(OnboardingEvents.ShowAlert)
                },
                accept = {
                    listener(OnboardingEvents.LoginRequest)
                }
            )
        }
    }
}

