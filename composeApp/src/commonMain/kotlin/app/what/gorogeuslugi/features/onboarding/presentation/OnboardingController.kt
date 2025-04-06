package app.what.gorogeuslugi.features.onboarding.presentation

import androidx.lifecycle.viewModelScope
import app.what.gorogeuslugi.data.AppSettings
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingActions
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingEvents
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingState
import app.what.gorogeuslugi.foundation.core.UIController
import app.what.gorogeuslugi.foundation.data.RemoteState
import app.what.gorogeuslugi.foundation.utils.safeExecute
import app.what.gorogeuslugi.network.api.Api
import app.what.gorogeuslugi.network.api.ApiClient

class OnboardingController(
    private val request: ApiClient
) : UIController<OnboardingState, OnboardingActions, OnboardingEvents>(
    OnboardingState()
) {

    override fun obtainEvent(viewEvent: OnboardingEvents) = when (viewEvent) {
        OnboardingEvents.HidePassword -> {
            updateState { copy(isPasswordVisible = !isPasswordVisible) }

        }

        is OnboardingEvents.LoginText -> {
            updateState { copy(login = viewEvent.text) }
        }

        is OnboardingEvents.PasswordText -> {
            updateState { copy(password = viewEvent.text) }
        }

        is OnboardingEvents.CodeText -> {
            updateState { copy(password = viewEvent.text) }
        }

        OnboardingEvents.ShowAlert -> {
            updateState { copy(showAlertDialog = !showAlertDialog) }
        }

        OnboardingEvents.LoginRequest -> {
            sendData(false)
            setAction(OnboardingActions.NavigateToGeneral)
        }

        OnboardingEvents.AuthorizationClick -> {}
        OnboardingEvents.LoginByEsin -> {
            sendData(true)
            setAction(OnboardingActions.NavigateToGeneral)
        }

        is OnboardingEvents.AuthType -> updateState(viewState.copy(isEsia = viewEvent.isEsia))
    }

    private fun sendData(isEsia: Boolean) {
        updateState {
            copy(loadingState = RemoteState.Loading)
        }

        safeExecute(
            scope = viewModelScope,
            block = {
                if (isEsia) {
                    val request = request.esiaLogin(
                        Api.Esia.Login.Request(
                            viewState.login,
                            viewState.password,
                            viewState.code
                        )
                    )

                    AppSettings.setToken(request.jwtToken)
                } else {
                    val request = request.authLogin(
                        Api.Auth.Login.Request(
                            viewState.login,
                            viewState.password
                        )
                    )

                    AppSettings.setToken(request.access_token)
                }

                updateState {
                    copy(
                        loadingState = RemoteState.Success
                    )
                }
            },
            failure = {
                updateState {
                    copy(
                        loadingState = RemoteState.Error
                    )
                }
            }
        )
    }
}

