package app.what.gorogeuslugi.foundation.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface UIComponent {
    @Composable
    fun content(modifier: Modifier): Any
}