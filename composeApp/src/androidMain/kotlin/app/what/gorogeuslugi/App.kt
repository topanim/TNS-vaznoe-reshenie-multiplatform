package app.what.gorogeuslugi

import android.app.Application
import android.content.Context
import app.what.gorogeuslugi.di.initKoin
import app.what.gorogeuslugi.di.initLogs
import org.koin.dsl.module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initLogs()
        initKoin(appModule = module { single<Context> { this@MainApplication } })
    }
}

