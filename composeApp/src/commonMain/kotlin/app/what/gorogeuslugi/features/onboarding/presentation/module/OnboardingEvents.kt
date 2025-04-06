package app.what.gorogeuslugi.features.onboarding.presentation.module

sealed interface OnboardingEvents {
    class CodeText(val text: String) : OnboardingEvents
    class AuthType(val isEsia: Boolean) : OnboardingEvents
    object AuthorizationClick : OnboardingEvents
    object HidePassword : OnboardingEvents
    data class LoginText(val text: String) : OnboardingEvents
    data class PasswordText(val text: String) : OnboardingEvents
    object ShowAlert : OnboardingEvents
    object LoginRequest : OnboardingEvents
    object LoginByEsin : OnboardingEvents
}