package app.what.gorogeuslugi.features.onboarding.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.what.gorogeuslugi.components.CustomButton
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.theme.buttonBlack
import app.what.gorogeuslugi.theme.buttonGreen
import app.what.gorogeuslugi.theme.buttonLight
import gorogeuslugi.composeapp.generated.resources.Res
import gorogeuslugi.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun AuthorizationPage(nextPage: () -> Unit,esin:()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .systemBarsPadding(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(Res.drawable.logo), "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            title = "Авторизоваться",
            color = buttonGreen,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
            nextPage()
        }

        Gap(8)
        CustomButton(
            title = "Войти через ЕСИА (Госуслуги)",
            color = buttonBlack,
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)
        ) {
          esin()
        }

        Gap(20)
    }
}