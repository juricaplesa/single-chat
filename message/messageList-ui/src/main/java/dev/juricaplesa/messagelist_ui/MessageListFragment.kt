package dev.juricaplesa.messagelist_ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.juricaplesa.components.BaseFragment
import dev.juricaplesa.messagelist_ui.adapter.MessageListAdapter
import dev.juricaplesa.messagelist_ui.databinding.FragmentMessageListBinding

@AndroidEntryPoint
class MessageListFragment : BaseFragment<MessageListViewModel, FragmentMessageListBinding>(),
    View.OnClickListener {

    override val viewModel: MessageListViewModel by viewModels()
    override fun getViewBinding() = FragmentMessageListBinding.inflate(layoutInflater)

    private val adapter = MessageListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupActionBar(binding.toolbar.toolbar)
        binding.toolbar.toolbarTitle.text = getString(R.string.message_list_title)
        setupRecyclerView(binding)

        binding.send.setOnClickListener(this)

        viewModel.previousMessages.observe(viewLifecycleOwner) { data ->
            adapter.addPreviousData(data)
            binding.recyclerView.scrollToPosition(0)
        }

        viewModel.newMessages.observe(viewLifecycleOwner) { data ->
            adapter.addNewData(data)
            binding.recyclerView.scrollToPosition(0)
        }

        viewModel.getPreviousMessages()
        viewModel.getNewMessages()
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

        //scroll to start after keyboard pops
        binding.recyclerView.addOnLayoutChangeListener { _, _, _, _, bottom, _, _, _, oldBottom ->
            if (bottom < oldBottom) {
                binding.recyclerView.postDelayed({
                    binding.recyclerView.smoothScrollToPosition(0)
                }, 100)
            }
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