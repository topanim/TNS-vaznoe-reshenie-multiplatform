package app.what.gorogeuslugi.features.onboarding.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.window.Popup
import app.what.gorogeuslugi.components.CustomButton
import app.what.gorogeuslugi.components.CustomTextField
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingEvents
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.foundation.ui.useState
import app.what.gorogeuslugi.theme.buttonBlack


@Composable
fun CustomAlertDialog(
    listener: Listener<OnboardingEvents>,
    onClose: () -> Unit,
    accept: () -> Unit
) {
    Popup(

        alignment = Alignment.Center,
        onDismissRequest = { onClose() },
    ) {
        var code by useState("")

        Box(
            modifier = Modifier.wrapContentSize()
                .padding(horizontal = 30.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .border(2.dp, color = Color(0xFFebeef1), RoundedCornerShape(12.dp)),
        ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Код подтверждения",
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 20.sp,
                    color = buttonBlack,
                    textAlign = TextAlign.Center
                )
                Gap(10)
                HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp))
                Gap(15)
                CustomTextField(
                    placeholder = "Код подтверждения",
                    fieldColor = Color.White,
                    trailingImage = null,
                    leadingImage = null,
                    inputText = { code = it }
                )
                Gap(15)

                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
                    CustomButton(
                        title = "Отменить",
                        color = Color(0xFFebeef1),
                        textColor = buttonBlack,
                        modifier = Modifier.weight(1f)
                    ) {
                        onClose()
                    }

                    Gap(20)

                    CustomButton(
                        title = "Подтвердить",
                        modifier = Modifier.weight(1f)
                    ) {
                        listener(OnboardingEvents.CodeText(code))
                        accept()
                    }
                }
            }
        }
    }
}