package app.what.gorogeuslugi.features.voting.domain.models

sealed interface VotingEvent {
    object GoBack : VotingEvent
    object Vote : VotingEvent
    class Init(val meetId: Int) : VotingEvent
}