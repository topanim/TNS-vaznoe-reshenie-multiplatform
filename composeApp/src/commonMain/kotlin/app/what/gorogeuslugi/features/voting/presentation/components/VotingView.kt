package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.components.CustomButton
import app.what.gorogeuslugi.components.HeaderWidget
import app.what.gorogeuslugi.features.voting.domain.models.VotingEvent
import app.what.gorogeuslugi.features.voting.domain.models.VotingState
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.navigation.core.rememberSheetController
import app.what.gorogeuslugi.theme.buttonBlack
import app.what.gorogeuslugi.theme.buttonGreen

@Composable
fun VotingView(
    state: VotingState,
    listener: Listener<VotingEvent>,
    modifier: Modifier = Modifier
) = Column(
    verticalArrangement = Arrangement.SpaceBetween,
    modifier = Modifier
        .padding(horizontal = 12.dp)
        .systemBarsPadding()
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(rememberScrollState())
) {
    val sheetController = rememberSheetController()
    Column {
        HeaderWidget(state.meet?.title ?: "") {
            listener(VotingEvent.GoBack)
        }

        Text(
            "Повестка дня",
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            lineHeight = 20.sp,
            color = buttonBlack
        )
        Gap(12)
        QuestionBlock(state.questions)
        Gap(12)
        HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(16.dp))
        Gap(12)
        CommentsBlock(state.meet?.ai_comment ?: "")
        Gap(12)
        HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(16.dp))
        Gap(12)
        InfoBlock()
        Gap(12)
        HorizontalDivider(modifier = Modifier.fillMaxWidth().padding(16.dp))
        Gap(12)
        ProtocolBlock(state.sendDoc ?: "")
        Gap(12)
    }

    Column {
        CustomButton(
            title = "Голосование",
            color = buttonGreen,
            modifier = Modifier.fillMaxWidth(),
            action = { sheetController.open(true) { VotingSheet(state, listener) } }
        )

        Gap(10)

        CustomButton(
            title = "Отменить голосование",
            color = buttonBlack,
            modifier = Modifier.fillMaxWidth(),
            action = { listener(VotingEvent.GoBack) }
        )
        Gap(20)
    }
}
