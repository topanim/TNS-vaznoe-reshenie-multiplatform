package app.what.gorogeuslugi.features.general.presentation

import androidx.lifecycle.viewModelScope
import app.what.gorogeuslugi.features.general.presentation.models.FilterType
import app.what.gorogeuslugi.features.general.presentation.models.GeneralEvents
import app.what.gorogeuslugi.features.general.presentation.models.GeneralState
import app.what.gorogeuslugi.features.general.presentation.models.GeneralsActions
import app.what.gorogeuslugi.features.general.presentation.models.GeneralsActions.NavigationToCreateEvent
import app.what.gorogeuslugi.features.general.presentation.models.GeneralsActions.NavigationToDetail
import app.what.gorogeuslugi.features.general.presentation.models.TimeEvent
import app.what.gorogeuslugi.foundation.core.UIController
import app.what.gorogeuslugi.foundation.data.RemoteState
import app.what.gorogeuslugi.foundation.utils.safeExecute
import app.what.gorogeuslugi.network.api.Api
import app.what.gorogeuslugi.network.api.ApiClient
import co.touchlab.kermit.Logger
import kotlinx.coroutines.async

class GeneralController(
    private val apiClient: ApiClient
) : UIController<GeneralState, GeneralsActions, GeneralEvents>(GeneralState()) {
    override fun obtainEvent(viewEvent: GeneralEvents) = when (viewEvent) {
        is GeneralEvents.SelectTimeFilter -> setTimeFilter(viewEvent.timeEvent)
        is GeneralEvents.SelectFilter -> setFilter(viewEvent.filter)
        is GeneralEvents.NavigationToDetail -> {
            setAction(NavigationToDetail(viewEvent.id))
        }

        GeneralEvents.FetchData -> fetchData()
        GeneralEvents.NavigationToCreateEvent -> setAction(NavigationToCreateEvent)
    }

    private fun fetchData() {
        updateState {
            copy(
                loadingState = RemoteState.Loading
            )
        }
        safeExecute(
            scope = viewModelScope,
            failure = {
                Logger.d { it.message.toString() }
                updateState {
                    copy(
                        loadingState = RemoteState.Loading
                    )
                }

            }
        ) {
            val request = apiClient.meetingsGetAll(Api.Meetings.GetAll.Request())

            updateState {
                copy(
                    data = request,
                    loadingState = RemoteState.Success
                )
            }
        }
    }

    private fun setTimeFilter(time: TimeEvent) {
        updateState {
            copy(
                timeEvent = time
            )
        }
    }

    private fun setFilter(type: FilterType) {
        updateState {
            copy(
                filterType = type
            )
        }
    }
}