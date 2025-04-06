import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import app.what.gorogeuslugi.data.AppSettings
import app.what.gorogeuslugi.di.initKoin
import app.what.gorogeuslugi.features.create_event.navigation.createEventRegistry
import app.what.gorogeuslugi.features.main.navigation.MainProvider
import app.what.gorogeuslugi.features.main.navigation.mainRegistry
import app.what.gorogeuslugi.features.onboarding.navigation.OnboardingProvider
import app.what.gorogeuslugi.features.onboarding.navigation.onboardingRegistry
import app.what.gorogeuslugi.features.voting.navigation.votingRegistry
import app.what.gorogeuslugi.navigation.core.NavigationHost
import app.what.gorogeuslugi.navigation.core.ProvideGlobalSheet
import app.what.gorogeuslugi.theme.GorogeuslugiTheme
import org.jetbrains.compose.reload.DevelopmentEntryPoint
import java.awt.Dimension

fun main() = application {
    initKoin()
    Window(
        title = "gorogeuslugi",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        DevelopmentEntryPoint {
            GorogeuslugiTheme {
                ProvideGlobalSheet {
                    NavigationHost(
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