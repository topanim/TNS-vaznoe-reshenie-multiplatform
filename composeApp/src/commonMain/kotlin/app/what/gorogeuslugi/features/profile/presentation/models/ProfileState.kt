package app.what.gorogeuslugi.features.profile.presentation.models

import app.what.gorogeuslugi.network.api.Api

data class ProfileState(
    val isLoading: Boolean = false,
    val name: String = "Архипова Дарья Эдуардовна",
    val position: String = "Директор",
    val board: String = "Комитет по охране труда",
    val user: Api.Users.Me.Response? = null
)
