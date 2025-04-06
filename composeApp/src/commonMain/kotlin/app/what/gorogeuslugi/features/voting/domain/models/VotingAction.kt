package app.what.gorogeuslugi.features.voting.domain.models

sealed interface VotingAction {
    object GoBack : VotingAction
}