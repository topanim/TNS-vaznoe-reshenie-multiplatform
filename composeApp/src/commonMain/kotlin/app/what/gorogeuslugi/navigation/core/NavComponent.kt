package app.what.gorogeuslugi.navigation.core

import app.what.gorogeuslugi.foundation.core.UIComponent

interface NavComponent<P : NavProvider> : UIComponent {
    val data: P
}