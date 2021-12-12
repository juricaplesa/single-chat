package dev.juricaplesa.components

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<viewModelClass : BaseViewModel, viewBindingClass : ViewBinding> : Fragment() {

    protected abstract val viewModel: viewModelClass
    abstract fun getViewBinding(): viewBindingClass

    private var _binding: viewBindingClass? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.errorMessage.observe(viewLifecycleOwner, { event ->
            event.getContentIfNotHandled()?.let { stringResourceId ->
                showToastMessage(stringResourceId)
            }
        })
    }

    private fun showToastMessage(stringResourceId: Int) {
        activity?.let {
            Toast.makeText(it, getString(stringResourceId), Toast.LENGTH_SHORT).show()
        }
    }

    fun setupActionBar(toolbar: Toolbar) {
        setActionBar(toolbar)
    }

    private fun setActionBar(toolbar: Toolbar) {
        if (activity is AppCompatActivity) {
            val activity = activity as AppCompatActivity
            activity.setSupportActionBar(toolbar)
            activity.supportActionBar?.apply {
                setDisplayShowTitleEnabled(false)
            }
        }
    }

}