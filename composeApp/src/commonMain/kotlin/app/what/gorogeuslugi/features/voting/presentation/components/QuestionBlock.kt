package app.what.gorogeuslugi.features.voting.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.what.gorogeuslugi.foundation.ui.Gap
import app.what.gorogeuslugi.network.api.Api
import app.what.gorogeuslugi.theme.buttonBlack

@Composable
fun QuestionBlock(questions: List<Api.Questions.GetAllByMeeting.Response.Question>) =
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        questions.forEachIndexed { index, question ->
            QuestionItem(index + 1, question.text)
        }
    }

@Composable
fun QuestionItem(count: Int, question: String) = Row(modifier = Modifier.wrapContentSize()) {
    Text(
        "${count}. $question",
        fontSize = 14.sp,
        fontWeight = FontWeight(600),
        lineHeight = 14.sp,
        color = buttonBlack,
        textAlign = TextAlign.Start
    )
}