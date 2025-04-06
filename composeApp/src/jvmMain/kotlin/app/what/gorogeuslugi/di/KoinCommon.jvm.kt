package app.what.gorogeuslugi.di


import androidx.compose.runtime.Composable
import java.awt.Desktop
import java.net.URI

actual object BrowserOpener {
    @Composable
    actual fun openUrl(url: String) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(URI(url))
        } else {
            println("Открытие браузера не поддерживается на этой платформе")
        }
    }
}