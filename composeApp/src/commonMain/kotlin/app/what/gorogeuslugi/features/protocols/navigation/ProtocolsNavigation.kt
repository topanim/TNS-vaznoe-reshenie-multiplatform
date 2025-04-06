package app.what.gorogeuslugi.features.protocols.navigation

import app.what.gorogeuslugi.features.protocols.ProtocolsFeature
import app.what.gorogeuslugi.navigation.core.NavProvider
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.register
import kotlinx.serialization.Serializable


val protocolsRegistry: Registry = {
    register(ProtocolsFeature::class)
}

@Serializable
object ProtocolProvider : NavProvider()