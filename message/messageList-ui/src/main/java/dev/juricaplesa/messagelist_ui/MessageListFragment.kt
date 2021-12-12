package dev.juricaplesa.messagelist_ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.juricaplesa.components.BaseFragment
import dev.juricaplesa.messagelist_ui.adapter.MessageListAdapter
import dev.juricaplesa.messagelist_ui.databinding.FragmentMessageListBinding
import dev.juricaplesa.messagelist_ui.model.MessageUI
import org.koin.android.ext.android.inject

class MessageListFragment : BaseFragment<MessageListViewModel>(R.layout.fragment_message_list) {

    override val viewModel: MessageListViewModel by inject()

    private val adapter = MessageListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMessageListBinding.bind(view)

        setupRecyclerView(binding)
        adapter.setData(listOf(MessageUI("test1"), MessageUI("test2"), MessageUI("test3"), MessageUI("test4"),MessageUI("test5")))
    }

    private fun setupRecyclerView(binding: FragmentMessageListBinding) {
        binding.recyclerView.layoutManager = LinearLayoutManager(context).apply { reverseLayout = true }
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
    }

}