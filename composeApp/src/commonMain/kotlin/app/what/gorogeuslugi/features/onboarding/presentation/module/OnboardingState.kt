package app.what.gorogeuslugi.features.onboarding.presentation.module

import app.what.gorogeuslugi.foundation.data.RemoteState

data class OnboardingState(
    val login: String = "",
    val password: String = "",
    val code: String = "",
    val isEsia: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val showAlertDialog: Boolean = false,
    val loadingState: RemoteState = RemoteState.Empty
)
