package app.what.gorogeuslugi.features.general.presentation.models

sealed interface GeneralsActions {
    data class NavigationToDetail(val id: Int) : GeneralsActions
    object NavigationToCreateEvent : GeneralsActions
}