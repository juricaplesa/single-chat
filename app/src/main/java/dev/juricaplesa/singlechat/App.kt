package dev.juricaplesa.singlechat

import android.app.Application
import dev.juricaplesa.message_data.di.messageDataModule
import dev.juricaplesa.message_domain.di.messageDomainModule
import dev.juricaplesa.messagelist_ui.di.messageListUiModule
import dev.juricaplesa.core_data.di.databaseModule
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
            modules(coreModules + messageModules + userModules)
        }
    }

}

val coreModules = listOf(databaseModule)
val messageModules = listOf(messageDomainModule, messageDataModule, messageListUiModule)
val userModules = listOf(userDomainModule, userDataModule)