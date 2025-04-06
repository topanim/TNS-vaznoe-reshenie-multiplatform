package app.what.gorogeuslugi.features.create_event.presentation

import androidx.lifecycle.viewModelScope
import app.what.gorogeuslugi.features.create_event.domain.CreateEventUseCase
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateAction
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateEvent
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateState
import app.what.gorogeuslugi.foundation.core.UIController
import app.what.gorogeuslugi.network.api.Api
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateController :
    UIController<CreateState, CreateAction, CreateEvent>(CreateState.default), KoinComponent {

    private val saveUseCase: CreateEventUseCase by inject()

    override fun obtainEvent(viewEvent: CreateEvent) = when (viewEvent) {
        CreateEvent.OnBack -> onBack()
        CreateEvent.OnSave -> onSave()
        is CreateEvent.SetDateStart -> setValue(viewEvent.dateStart, viewEvent)
        is CreateEvent.SetDateEnd -> setValue(viewEvent.dateEnd, viewEvent)
        is CreateEvent.SetAgenda -> setValue(viewEvent.agenda, viewEvent)
        is CreateEvent.SetDescription -> setValue(viewEvent.description, viewEvent)
        is CreateEvent.SetBoard -> setValue(viewEvent.board, viewEvent)
        is CreateEvent.SetFormat -> setValue(viewEvent.format, viewEvent)
        is CreateEvent.SetLink -> setValue(viewEvent.link, viewEvent)
    }

    private fun setValue(text: String, viewEvent: CreateEvent) {
        when (viewEvent) {
            is CreateEvent.SetDateStart -> updateState { copy(dateStart = text) }
            is CreateEvent.SetDateEnd -> updateState { copy(dateEnd = text) }
            is CreateEvent.SetAgenda -> updateState { copy(agenda = text) }
            is CreateEvent.SetBoard -> updateState { copy(board = text) }
            is CreateEvent.SetDescription -> updateState { copy(description = text) }
            is CreateEvent.SetFormat -> updateState { copy(format = text) }
            is CreateEvent.SetLink -> updateState { copy(link = text) }
            else -> {}
        }
    }

    private fun onBack() {
        updateState { CreateState.default }
        setAction(CreateAction.OnBack)
    }

    private fun onSave() {
        viewModelScope.launch {
            saveUseCase.invoke(Api.Meetings.Create.Request(
                title = viewState.agenda,
                text = viewState.description,
                status = false,
                meeting_link = viewState.link,
                role_id = 0,
                ai_comment = "",
                id = 1
            ))
            setAction(CreateAction.OnBack)
        }
    }
}