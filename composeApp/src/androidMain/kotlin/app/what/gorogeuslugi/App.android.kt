package app.what.gorogeuslugi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.Modifier
import app.what.gorogeuslugi.data.AppSettings
import app.what.gorogeuslugi.features.create_event.navigation.createEventRegistry
import app.what.gorogeuslugi.features.main.navigation.MainProvider
import app.what.gorogeuslugi.features.main.navigation.mainRegistry
import app.what.gorogeuslugi.features.onboarding.navigation.OnboardingProvider
import app.what.gorogeuslugi.features.onboarding.navigation.onboardingRegistry
import app.what.gorogeuslugi.features.voting.navigation.votingRegistry
import app.what.gorogeuslugi.navigation.core.NavigationHost
import app.what.gorogeuslugi.navigation.core.ProvideGlobalSheet
import app.what.gorogeuslugi.theme.GorogeuslugiTheme

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GorogeuslugiTheme {
                ProvideGlobalSheet {
                    NavigationHost(
                        modifier = Modifier.background(colorScheme.background),
                        start = if (AppSettings.getTokenOrNull() == null) OnboardingProvider else
                            MainProvider
                    ) {
                        onboardingRegistry()
                        mainRegistry()
                        votingRegistry()
                        createEventRegistry()
                    }
                }
            }
        }
    }
}