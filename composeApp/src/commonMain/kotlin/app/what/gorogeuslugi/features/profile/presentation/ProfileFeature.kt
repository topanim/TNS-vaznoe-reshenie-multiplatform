package app.what.gorogeuslugi.features.profile.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.features.profile.navigation.ProfileProvider
import app.what.gorogeuslugi.features.profile.presentation.models.ProfileEvent
import app.what.gorogeuslugi.features.profile.presentation.ui.ProfileView
import app.what.gorogeuslugi.foundation.core.Feature
import app.what.gorogeuslugi.navigation.core.NavComponent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class ProfileScreen(override val data: ProfileProvider) : NavComponent<ProfileProvider>,
    Feature<ProfileController, ProfileEvent>(), KoinComponent {
    override val controller: ProfileController by inject()

    @Composable
    override fun content(modifier: Modifier) {
        val state by controller.collectStates()
        val action by controller.collectActions()
        LaunchedEffect(Unit) {
            listener(ProfileEvent.FetchData)
        }
        ProfileView(state, listener)
    }

}