package app.what.gorogeuslugi.features.create_event.navigation

import app.what.gorogeuslugi.features.create_event.CreateScreen
import app.what.gorogeuslugi.navigation.core.NavProvider
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.register
import kotlinx.serialization.Serializable

val createEventRegistry: Registry = {
    register(CreateScreen::class)
}

@Serializable
object CreateProvider : NavProvider()