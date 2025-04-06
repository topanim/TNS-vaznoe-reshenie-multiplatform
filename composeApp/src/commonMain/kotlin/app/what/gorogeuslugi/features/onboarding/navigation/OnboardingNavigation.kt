package app.what.gorogeuslugi.features.onboarding.navigation

import app.what.gorogeuslugi.features.onboarding.OnboardingFeature
import app.what.gorogeuslugi.navigation.core.NavProvider
import app.what.gorogeuslugi.navigation.core.Registry
import app.what.gorogeuslugi.navigation.core.register
import kotlinx.serialization.Serializable

val onboardingRegistry: Registry = {
    register(OnboardingFeature::class)
}

@Serializable
object OnboardingProvider : NavProvider()