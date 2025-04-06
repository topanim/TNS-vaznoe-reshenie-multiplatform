package app.what.gorogeuslugi.features.profile.navigation

import app.what.gorogeuslugi.features.profile.presentation.ProfileScreen
import app.what.gorogeuslugi.navigation.core.NavProvider
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.register
import kotlinx.serialization.Serializable

val profileRegistry: Registry = {
    register(ProfileScreen::class)
}

@Serializable
object ProfileProvider : NavProvider()