package app.what.gorogeuslugi.di

import app.what.gorogeuslugi.features.create_event.domain.CreateEventUseCase
import app.what.gorogeuslugi.features.create_event.domain.CreateEventUseCaseImpl
import app.what.gorogeuslugi.features.create_event.presentation.CreateController
import app.what.gorogeuslugi.data.AppSettings
import app.what.gorogeuslugi.features.general.presentation.GeneralController
import app.what.gorogeuslugi.features.main.domain.MainController
import app.what.gorogeuslugi.features.onboarding.presentation.OnboardingController
import app.what.gorogeuslugi.features.profile.presentation.ProfileController
import app.what.gorogeuslugi.features.protocols.presentation.ProtocolController
import app.what.gorogeuslugi.features.voting.domain.VotingController
import app.what.gorogeuslugi.network.api.ApiClient
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

expect val platformModule: Module

fun initKoin(
    appModule: Module = module { }
) = startKoin {
    modules(
        platformModule,
        appModule,
        cvModule,
        useCasesModule
    )
}

val cvModule = module {
    single { VotingController(get()) }
    single { MainController() }
    single { GeneralController(get()) }
    single { ProfileController(get()) }
    single { ProtocolController() }
    single { CreateController() }
    single { OnboardingController(get()) }

    single {
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                })
            }

            install(Logging) {
                level = LogLevel.ALL
                logger = object : Logger {
                    override fun log(message: String) {
                        appLog(message)
                    }
                }
            }
        }
    }

    single { ApiClient(get()) }
    single { AppSettings }
}

val useCasesModule = module {
    singleOf(::CreateEventUseCaseImpl) { bind<CreateEventUseCase>() }
}

fun appLog(message: String) {
    Napier.d("🚀 $message")
}

fun initLogs() = Napier.base(DebugAntilog())