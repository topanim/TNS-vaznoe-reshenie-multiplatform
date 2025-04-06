package app.what.gorogeuslugi.features.voting.domain

import androidx.lifecycle.viewModelScope
import app.what.gorogeuslugi.features.voting.domain.models.VotingAction
import app.what.gorogeuslugi.features.voting.domain.models.VotingEvent
import app.what.gorogeuslugi.features.voting.domain.models.VotingState
import app.what.gorogeuslugi.foundation.core.UIController
import app.what.gorogeuslugi.foundation.utils.safeExecute
import app.what.gorogeuslugi.network.api.Api
import app.what.gorogeuslugi.network.api.ApiClient
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll

class VotingController(
    private val api: ApiClient
) : UIController<VotingState, VotingAction, VotingEvent>(
    VotingState()
) {
    override fun obtainEvent(viewEvent: VotingEvent) {
        when (viewEvent) {
            VotingEvent.GoBack -> setAction(VotingAction.GoBack)
            is VotingEvent.Init -> fetchData(viewEvent.meetId)
            is VotingEvent.Vote -> vote()
        }
    }

    private fun vote() {
        if (viewState.questions.any { it.answer == null })
            return

        safeExecute(
            scope = viewModelScope
        ) {
            viewState.questions.map {
                async {
                    api.votesCreate(
                        Api.Votes.Create.Request(
                            question_id = it.id ?: 0,
                            choice = it.answer!!.name
                        )
                    )
                }
            }.forEach { it.await() }

            setAction(VotingAction.GoBack)
        }
    }


    private fun fetchData(meetId: Int) {
        safeExecute(
            scope = viewModelScope,
            block = {
                val meetDeferred = async {
                    api.meetingsGetOne(Api.Meetings.GetOne.Request(meetId))
                }

                val questionsDeferred = async {
                    api.questionsGetAllByMeeting(Api.Questions.GetAllByMeeting.Request(meetId))
                }

                val sendDocDeffered = async {
                    api.meetingsSendDoc(Api.Meetings.SendDoc.Request(meetId))
                }

                val meet = meetDeferred.await()
                val question = questionsDeferred.await()
                val sendDoc = sendDocDeffered.await()

                updateState {
                    copy(
                        sendDoc = sendDoc,
                        meetId = meetId,
                        meet = meet,
                        questions = question
                    )
                }
            }
        )
    }
}