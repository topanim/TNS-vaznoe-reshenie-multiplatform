package app.what.gorogeuslugi.features.general.presentation.models

import app.what.gorogeuslugi.foundation.data.RemoteState
import app.what.gorogeuslugi.network.api.Api

data class GeneralState(
    val data: List<Api.Meetings.GetAll.Response.Meeting> = emptyList(),
    val timeEvent: TimeEvent = TimeEvent.CURRENT,
    val filterType: FilterType = FilterType.DATE,
    val loadingState: RemoteState = RemoteState.Empty
)

enum class TimeEvent {
    CURRENT, PAST
}

enum class FilterType {
    DATE, COMMITED, SIT_TYPE
}
