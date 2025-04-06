package app.what.gorogeuslugi.di

import app.what.gorogeuslugi.data.AppSettings
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.storeOf
import org.koin.core.module.Module
import org.koin.dsl.module
import java.io.File

actual val platformModule: Module  = module {}
