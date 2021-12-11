package dev.juricaplesa.messagelist_ui

import org.koin.android.ext.android.inject

class MessageListFragment : BaseFragment<MessageListViewModel>(R.layout.fragment_message_list) {

    override val viewModel: MessageListViewModel by inject()

}