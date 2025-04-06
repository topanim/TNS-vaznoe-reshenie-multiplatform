package app.what.gorogeuslugi.features.voting.navigation

import app.what.gorogeuslugi.features.voting.presentation.VotingFeature
import app.what.gorogeuslugi.navigation.core.NavProvider
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.register
import kotlinx.serialization.Serializable

val votingRegistry: Registry = {
    register(VotingFeature::class)
}

@Serializable
data class VotingProvider(
    val id: Int
) : NavProvider()