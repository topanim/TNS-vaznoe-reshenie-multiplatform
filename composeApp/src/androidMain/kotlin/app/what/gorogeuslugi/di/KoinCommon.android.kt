package app.what.gorogeuslugi.di

import app.what.gorogeuslugi.data.AppSettings
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storeOf
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File
import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toUri


actual val platformModule: Module  = module {}

actual object BrowserOpener {
    @Composable
    actual fun openUrl(url: String) {
        val context = LocalContext.current
        if (context is ComponentActivity) {
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            context.startActivity(intent)
        }
    }
}
