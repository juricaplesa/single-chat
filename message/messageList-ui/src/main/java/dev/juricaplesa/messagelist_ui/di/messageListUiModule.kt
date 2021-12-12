package dev.juricaplesa.messagelist_ui.di

import dev.juricaplesa.messagelist_ui.MessageListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val messageListUiModule = module {

    viewModel { MessageListViewModel(get(), get()) }

}