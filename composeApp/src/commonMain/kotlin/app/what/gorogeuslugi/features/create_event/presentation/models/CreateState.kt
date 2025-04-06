package app.what.gorogeuslugi.features.create_event.presentation.models

data class CreateState(
    val dateStart: String,
    val dateEnd: String,
    val agenda: String,
    val description: String,
    val board: String,
    val format: String,
    val link: String
) {
    companion object {
        val default = CreateState(
            dateStart = "",
            dateEnd = "",
            agenda = "",
            description = "",
            board = "",
            format = "",
            link = ""
        )
    }
}
