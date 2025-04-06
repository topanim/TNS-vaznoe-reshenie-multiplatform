package app.what.gorogeuslugi.features.voting.domain.models

import app.what.gorogeuslugi.foundation.core.Monitor.Companion.monitored
import app.what.gorogeuslugi.network.api.Api
import java.time.LocalDate

data class VotingState(
    val meetId: Int? = null,
    val meet: Api.Meetings.GetOne.Response? = null,
    val questions: List<Api.Questions.GetAllByMeeting.Response.Question> = emptyList(),
)

data class Voting(
    val title: String,
    val description: String,
    val aiComment: String,
    val commitetName: String,
    val startDate: LocalDate,
    val format: VotingFormat,
    val questions: List<Question>
) {
    var comment by monitored("")
}

data class Question(
    val id: Int,
    val question: String,
    val answers: Set<Answer>
) {
    var answer by monitored<Answer?>(null)
}

enum class VotingFormat {
    DISTANT, OFFLINE
}

enum class Answer(val realName: String) {
    YES("За"),
    NO("Против"),
    DONT_KNOW("Воздержался")
}