package dev.juricaplesa.singlechat

import android.app.Application
import dev.juricaplesa.singlechat.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModules)
        }
    }

}

val appModules = listOf(databaseModule)