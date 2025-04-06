package app.what.gorogeuslugi.features.profile.presentation

import androidx.lifecycle.viewModelScope
import app.what.gorogeuslugi.features.profile.presentation.models.ProfileActions
import app.what.gorogeuslugi.features.profile.presentation.models.ProfileEvent
import app.what.gorogeuslugi.features.profile.presentation.models.ProfileState
import app.what.gorogeuslugi.foundation.core.UIController
import app.what.gorogeuslugi.foundation.utils.safeExecute
import app.what.gorogeuslugi.network.api.ApiClient

class ProfileController(
    private val request: ApiClient
) :
    UIController<ProfileState, ProfileActions, ProfileEvent>(ProfileState()) {
    override fun obtainEvent(viewEvent: ProfileEvent) = when (viewEvent) {
        ProfileEvent.FetchData -> fetch()
    }

    private fun fetch() {
        safeExecute(
            scope = viewModelScope,
            block = {
                val data = request.userMe("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoxNSwicm9sZV9pZCI6MSwiZXhwIjoxNzQ0MjYxNDIyfQ.6y7nlkyandPbgpqsdpjVPJ2fHk28BOF_MIQBAhN2FLM")
                updateState { copy(user = data) }
            }
        )
    }
}