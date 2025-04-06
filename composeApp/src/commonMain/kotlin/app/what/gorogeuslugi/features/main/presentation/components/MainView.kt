package app.what.gorogeuslugi.features.main.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.main.domain.models.MainEvent
import app.what.gorogeuslugi.features.main.domain.models.MainState
import app.what.gorogeuslugi.features.main.presentation.MainFeature
import app.what.gorogeuslugi.foundation.core.Listener
import app.what.gorogeuslugi.navigation.core.NavigationHost
import app.what.gorogeuslugi.navigation.core.bottom_navigation.BottomNavBar
import app.what.gorogeuslugi.navigation.core.rememberHostNavigator

@Composable
fun MainView(
    state: MainState,
    listener: Listener<MainEvent>,
    modifier: Modifier = Modifier
) {
    val navigator = rememberHostNavigator()

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navigator, MainFeature.items
            )
        }
    ) {
        NavigationHost(
            modifier = modifier.padding(it),
            start = MainFeature.items.first().provider,
            navigator = navigator,
            registry = MainFeature.registry
        )
    }

}