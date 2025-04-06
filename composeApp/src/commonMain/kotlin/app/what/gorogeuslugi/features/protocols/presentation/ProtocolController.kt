package app.what.gorogeuslugi.features.protocols.presentation

import app.what.gorogeuslugi.features.protocols.presentation.models.ProtocolActions
import app.what.gorogeuslugi.features.protocols.presentation.models.ProtocolsEvents
import app.what.gorogeuslugi.features.protocols.presentation.models.ProtocolsState
import app.what.gorogeuslugi.foundation.core.UIController

class ProtocolController :
    UIController<ProtocolsState, ProtocolActions, ProtocolsEvents>(ProtocolsState()) {
    override fun obtainEvent(viewEvent: ProtocolsEvents) {

    }

}