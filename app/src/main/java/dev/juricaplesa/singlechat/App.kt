package dev.juricaplesa.singlechat

import android.app.Application
import dev.juricaplesa.message_data.di.messageDataModule
import dev.juricaplesa.message_domain.di.messageDomainModule
import dev.juricaplesa.singlechat.di.databaseModule
import dev.juricaplesa.user_data.di.userDataModule
import dev.juricaplesa.user_domain.di.userDomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModules + messageModules + userModules)
        }
    }

}

val appModules = listOf(databaseModule)
val messageModules = listOf(messageDomainModule, messageDataModule)
val userModules = listOf(userDomainModule, userDataModule)