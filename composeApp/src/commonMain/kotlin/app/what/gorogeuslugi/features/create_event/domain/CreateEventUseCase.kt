package app.what.gorogeuslugi.features.create_event.domain

import app.what.gorogeuslugi.network.api.Api
import app.what.gorogeuslugi.network.api.ApiClient

interface CreateEventUseCase {
    suspend operator fun invoke(request: Api.Meetings.Create.Request): Result<Api.Meetings.Create.Response>
}

internal class CreateEventUseCaseImpl(
    private val apiClient: ApiClient
) : CreateEventUseCase {
    override suspend fun invoke(request: Api.Meetings.Create.Request): Result<Api.Meetings.Create.Response> {
        return try {
            val request = apiClient.meetingsCreate(request)
            Result.success(request)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}