package app.what.gorogeuslugi.features.voting.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.voting.domain.VotingController
import app.what.gorogeuslugi.features.voting.domain.models.VotingAction
import app.what.gorogeuslugi.features.voting.domain.models.VotingEvent
import app.what.gorogeuslugi.features.voting.navigation.VotingProvider
import app.what.gorogeuslugi.features.voting.presentation.components.VotingView
import app.what.gorogeuslugi.foundation.core.Feature
import app.what.gorogeuslugi.navigation.core.NavComponent
import app.what.gorogeuslugi.navigation.core.rememberNavigator
import app.what.gorogeuslugi.navigation.core.rememberSheetController
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class VotingFeature(
    override val data: VotingProvider
) : Feature<VotingController, VotingEvent>(),
    NavComponent<VotingProvider>,
    KoinComponent {

    override val controller: VotingController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val viewState by controller.collectStates()
        val viewAction by controller.collectActions()
        val navigator = rememberNavigator()
        val sheetController = rememberSheetController()

        LaunchedEffect(Unit) {
            listener(VotingEvent.Init(data.id))
        }

        VotingView(viewState, listener, modifier)

        when (viewAction) {
            VotingAction.GoBack -> {
                sheetController.animateClose()
                navigator.c.navigateUp()
                controller.clearAction()
            }
            null -> Unit
        }
    }
}