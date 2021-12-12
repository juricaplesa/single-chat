package dev.juricaplesa.messagelist_ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dev.juricaplesa.components.BaseFragment
import dev.juricaplesa.messagelist_ui.adapter.MessageListAdapter
import dev.juricaplesa.messagelist_ui.databinding.FragmentMessageListBinding
import dev.juricaplesa.messagelist_ui.model.MessageUI
import org.koin.android.ext.android.inject

class MessageListFragment : BaseFragment<MessageListViewModel, FragmentMessageListBinding>(),
    View.OnClickListener {

    override val viewModel: MessageListViewModel by inject()
    override fun getViewBinding() = FragmentMessageListBinding.inflate(layoutInflater)

    private val adapter = MessageListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupActionBar(binding.toolbar.toolbar)
        binding.toolbar.toolbarTitle.text = getString(R.string.message_list_title)
        setupRecyclerView(binding)

        binding.send.setOnClickListener(this)

        adapter.addData(
            listOf(
                MessageUI("test1"),
                MessageUI("test2"),
                MessageUI("test3"),
                MessageUI("test4"),
                MessageUI("test5")
            )
        )

        viewModel.newMessages.observe(viewLifecycleOwner, { data ->
            adapter.addData(data)
        })

        viewModel.getMessages()
    }

    private fun setupRecyclerView(binding: FragmentMessageListBinding) {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context).apply { reverseLayout = true }
        binding.recyclerView.adapter = adapter

        //set divider
        context?.let { context ->
            binding.recyclerView.addItemDecoration(
                DividerItemDecoration(
                    context,
                    LinearLayoutManager.VERTICAL
                ).apply {
                    ContextCompat.getDrawable(context, R.drawable.divider_message_list)
                        ?.let { dividerDrawable -> setDrawable(dividerDrawable) }
                })
        }

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.send -> {
                viewModel.onSendClick(binding.input.text.toString())
                binding.input.text.clear()
            }
        }
    }

}