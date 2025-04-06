package app.what.gorogeuslugi.features.create_event

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.create_event.navigation.CreateProvider
import app.what.gorogeuslugi.features.create_event.presentation.CreateController
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateAction
import app.what.gorogeuslugi.features.create_event.presentation.models.CreateEvent
import app.what.gorogeuslugi.features.create_event.presentation.ui.CreateView
import app.what.gorogeuslugi.foundation.core.Feature
import app.what.gorogeuslugi.navigation.core.NavComponent
import app.what.gorogeuslugi.navigation.core.rememberNavigator
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateScreen(override val data: CreateProvider) : NavComponent<CreateProvider>,
    Feature<CreateController, CreateEvent>(), KoinComponent {
    override val controller: CreateController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        val navigator = rememberNavigator()

        CreateView(state, listener)

        when (action) {
            CreateAction.OnBack -> {
                navigator.c.navigateUp()
                controller.clearAction()
            }
            null -> {}
        }
    }

}