package app.what.gorogeuslugi.features.main.domain

import app.what.gorogeuslugi.features.main.domain.models.MainAction
import app.what.gorogeuslugi.features.main.domain.models.MainEvent
import app.what.gorogeuslugi.features.main.domain.models.MainState
import app.what.gorogeuslugi.foundation.core.UIController

class MainController : UIController<MainState, MainAction, MainEvent>(
    MainState()
) {
    override fun obtainEvent(viewEvent: MainEvent) {

    }
}