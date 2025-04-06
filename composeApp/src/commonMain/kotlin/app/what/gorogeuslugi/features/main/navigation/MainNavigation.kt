package app.what.gorogeuslugi.features.main.navigation

import app.what.gorogeuslugi.features.main.presentation.MainFeature
import app.what.gorogeuslugi.navigation.core.NavProvider
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.register
import kotlinx.serialization.Serializable

val mainRegistry: Registry = {
    register(MainFeature::class)
}

@Serializable
data object MainProvider : NavProvider()