package app.what.gorogeuslugi.features.general.navigation

import app.what.gorogeuslugi.features.general.GeneralFeature
import app.what.gorogeuslugi.navigation.core.NavProvider
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.register
import kotlinx.serialization.Serializable

val generalRegistry: Registry = {
    register(GeneralFeature::class)
}

@Serializable
object GeneralProvider : NavProvider()