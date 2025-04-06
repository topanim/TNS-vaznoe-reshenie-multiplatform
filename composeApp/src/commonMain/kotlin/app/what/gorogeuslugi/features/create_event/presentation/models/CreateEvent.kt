package app.what.gorogeuslugi.features.create_event.presentation.models

sealed interface CreateEvent {
    class SetDateStart(val dateStart: String) : CreateEvent
    class SetDateEnd(val dateEnd: String) : CreateEvent
    class SetAgenda(val agenda: String) : CreateEvent
    class SetDescription(val description: String) : CreateEvent
    class SetBoard(val board: String) : CreateEvent
    class SetFormat(val format: String) : CreateEvent
    class SetLink(val link: String) : CreateEvent
    data object OnBack : CreateEvent
    data object OnSave : CreateEvent
}