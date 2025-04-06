package app.what.gorogeuslugi.features.protocols

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.protocols.navigation.ProtocolProvider
import app.what.gorogeuslugi.features.protocols.presentation.ProtocolController
import app.what.gorogeuslugi.features.protocols.presentation.models.ProtocolsEvents
import app.what.gorogeuslugi.features.protocols.presentation.ui.ProtocolView
import app.what.gorogeuslugi.foundation.core.Feature
import app.what.gorogeuslugi.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProtocolsFeature(override val data: ProtocolProvider) : NavComponent<ProtocolProvider>,
    Feature<ProtocolController, ProtocolsEvents>(), KoinComponent {
    override val controller: ProtocolController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()

        ProtocolView(state, action)
    }
}