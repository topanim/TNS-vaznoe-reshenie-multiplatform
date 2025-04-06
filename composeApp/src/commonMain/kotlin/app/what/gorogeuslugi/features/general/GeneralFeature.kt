package app.what.gorogeuslugi.features.general

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.create_event.navigation.CreateProvider
import app.what.gorogeuslugi.features.general.navigation.GeneralProvider
import app.what.gorogeuslugi.features.general.presentation.GeneralController
import app.what.gorogeuslugi.features.general.presentation.models.GeneralEvents
import app.what.gorogeuslugi.features.general.presentation.models.GeneralsActions
import app.what.gorogeuslugi.features.general.presentation.ui.GeneralView
import app.what.gorogeuslugi.features.voting.navigation.VotingProvider
import app.what.gorogeuslugi.foundation.core.Feature
import app.what.gorogeuslugi.foundation.data.RemoteState
import app.what.gorogeuslugi.foundation.utils.orThrow
import app.what.gorogeuslugi.navigation.core.NavComponent
import app.what.gorogeuslugi.navigation.core.rememberNavigator
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class GeneralFeature(override val data: GeneralProvider) : NavComponent<GeneralProvider>,
    Feature<GeneralController, GeneralEvents>(), KoinComponent {
    override val controller: GeneralController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        val navigator = rememberNavigator().parent.orThrow

        LaunchedEffect(Unit) {
            listener(GeneralEvents.FetchData)
        }
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
                GeneralView(state, listener)
            }
        }


        when (action) {
            is GeneralsActions.NavigationToDetail -> {
                navigator.c.navigate(VotingProvider((action as GeneralsActions.NavigationToDetail).id))
                controller.clearAction()
            }
            GeneralsActions.NavigationToCreateEvent -> {
                navigator.c.navigate(CreateProvider)
                controller.clearAction()
            }
            null -> {}
        }
    }

}