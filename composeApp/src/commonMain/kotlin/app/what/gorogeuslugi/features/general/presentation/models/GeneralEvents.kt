package app.what.gorogeuslugi.features.general.presentation.models

sealed interface GeneralEvents {
    data class SelectTimeFilter(val timeEvent: TimeEvent) : GeneralEvents
    data class SelectFilter(val filter: FilterType) : GeneralEvents
    data class NavigationToDetail(val id: Int) : GeneralEvents
    object FetchData : GeneralEvents
    object NavigationToCreateEvent : GeneralEvents
}