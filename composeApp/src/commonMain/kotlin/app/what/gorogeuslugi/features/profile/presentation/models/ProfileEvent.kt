package app.what.gorogeuslugi.features.profile.presentation.models

sealed interface ProfileEvent{
    object FetchData : ProfileEvent
}