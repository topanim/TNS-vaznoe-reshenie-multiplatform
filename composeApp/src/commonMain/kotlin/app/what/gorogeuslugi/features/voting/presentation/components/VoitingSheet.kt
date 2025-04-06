package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.components.CustomButton
import app.what.gorogeuslugi.features.voting.domain.models.Answer
import app.what.gorogeuslugi.features.voting.domain.models.VotingEvent
import app.what.gorogeuslugi.features.voting.domain.models.VotingState
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.network.api.Api
import app.what.gorogeuslugi.theme.buttonGreen

private val answers = setOf(Answer.YES, Answer.NO, Answer.DONT_KNOW)

@Composable
fun QuestionUI(index: Int, data: Api.Questions.GetAllByMeeting.Response.Question) = Column {
    QuestionItem(index + 1, data.text)
    AnswersPanel(answers, data.answer) { data.answer = it }
}

@Composable
fun AnswersPanel(
    answers: Set<Answer>,
    selected: Answer?,
    onSelect: (Answer) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        answers.forEach { answer ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val checked = answer == selected

                Checkbox(
                    checked = checked,
                    colors = CheckboxDefaults.colors(checkedColor = buttonGreen),
                    onCheckedChange = { onSelect(answer) }
                )

                Gap(2)

                Text(answer.realName, color = if (checked) buttonGreen else Color.Black)
            }
        }
    }
}

val VotingSheet = @Composable
fun(
    state: VotingState,
    listener: Listener<VotingEvent>
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Text(
                text = "Голосование",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
                    .padding(top = 12.dp, bottom = 16.dp),
                textAlign = TextAlign.Left
            )

            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                state.questions.forEachIndexed { i, question ->
                    QuestionUI(i, question)
                }
            }
        }

        Gap(8)

        CustomButton("Подписать", modifier = Modifier.fillMaxWidth()) {
            listener(VotingEvent.Vote)
        }
    }
}