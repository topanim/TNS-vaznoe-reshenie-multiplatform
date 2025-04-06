package app.what.gorogeuslugi.features.main.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.general.navigation.GeneralProvider
import app.what.gorogeuslugi.features.general.navigation.generalRegistry
import app.what.gorogeuslugi.features.main.domain.MainController
import app.what.gorogeuslugi.features.main.domain.models.MainEvent
import app.what.gorogeuslugi.features.main.navigation.MainProvider
import app.what.gorogeuslugi.features.main.presentation.components.MainView
import app.what.gorogeuslugi.features.profile.navigation.ProfileProvider
import app.what.gorogeuslugi.features.profile.navigation.profileRegistry
import app.what.gorogeuslugi.features.protocols.navigation.ProtocolProvider
import app.what.gorogeuslugi.features.protocols.navigation.protocolsRegistry
import app.what.gorogeuslugi.foundation.core.Feature
import app.what.gorogeuslugi.navigation.core.NavComponent
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.bottom_navigation.navItem
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainFeature(
    override val data: MainProvider
) : Feature<MainController, MainEvent>(),
    NavComponent<MainProvider>,
    KoinComponent {

    override val controller: MainController by inject()

    companion object {
        val registry: Registry = {
            generalRegistry()
            profileRegistry()
            protocolsRegistry()
        }

        val items = listOf(
            navItem(
                "Главная",
                Icons.Default.Home,
                GeneralProvider
            ),
            navItem(
                "Протоколы",
                Icons.Default.Info,
                ProtocolProvider
            ),
            navItem(
                "Профиль",
                Icons.Default.Person,
                ProfileProvider
            )
        )
    }

    @Composable
    override fun content(modifier: Modifier) {
        val viewState by controller.collectStates()
        val viewAction by controller.collectActions()

        MainView(viewState, listener, modifier)
    }
}