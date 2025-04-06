package app.what.gorogeuslugi.features.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.main.navigation.MainProvider
import app.what.gorogeuslugi.features.onboarding.navigation.OnboardingProvider
import app.what.gorogeuslugi.features.onboarding.presentation.OnboardingController
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingActions
import app.what.gorogeuslugi.features.onboarding.presentation.module.OnboardingEvents
import app.what.gorogeuslugi.features.onboarding.presentation.ui.OnboardingView
import app.what.gorogeuslugi.foundation.core.Feature
import app.what.gorogeuslugi.foundation.data.RemoteState
import app.what.gorogeuslugi.navigation.core.NavComponent
import app.what.gorogeuslugi.navigation.core.rememberNavigator
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class OnboardingFeature(override val data: OnboardingProvider) : NavComponent<OnboardingProvider>,
    Feature<OnboardingController, OnboardingEvents>(), KoinComponent {
    override val controller: OnboardingController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        val navigation = rememberNavigator()

        OnboardingView(state, listener)

        when (action) {
            OnboardingActions.NavigateToGeneral -> {
                when(state.loadingState){
                    RemoteState.Empty -> {}
                    RemoteState.Error -> {}
                    RemoteState.Idle -> {}
                    RemoteState.Loading -> {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ){
                            CircularProgressIndicator()
                        }
                    }

                    RemoteState.Success -> {
                        navigation.c.navigate(MainProvider)
                        controller.clearAction()
                    }
                }
            }

            null -> {}
        }
    }
}