package app.what.gorogeuslugi.features.create_event.presentation.models

sealed interface CreateAction {
    data object OnBack : CreateAction
}