package com.mandarjoshi.androidnextgen.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mandarjoshi.androidnextgen.util.DialogUtil

import androidx.navigation.fragment.NavHostFragment
import com.mandarjoshi.androidnextgen.util.Constants

import com.mandarjoshi.androidnextgen.viewmodel.ActionViewModel
import com.mandarjoshi.androidnextgen.viewmodel.ViewModelFactory
import javax.inject.Inject
import com.mandarjoshi.androidnextgen.AndroidNextGenApplication
import com.mandarjoshi.androidnextgen.databinding.FragmentActionListBinding

import com.mandarjoshi.androidnextgen.util.Status
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ActionFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val mViewModel: ActionViewModel by activityViewModels { viewModelFactory }

    private lateinit var binding: FragmentActionListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().applicationContext as AndroidNextGenApplication).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentActionListBinding.inflate(inflater, container, false)
        binding.actionList.layoutManager = LinearLayoutManager(context)
        observeDataState()
        return binding.root
    }

    private fun navigateToScores(id: String) {
        val bundle = Bundle()
        bundle.putString(Constants.ACTION_ID_KEY, id)
        NavHostFragment.findNavController(this)
            .navigate(com.mandarjoshi.androidnextgen.R.id.navigate_to_action_details, bundle)
    }

    private fun observeDataState(){
        lifecycleScope.launch {
            mViewModel.uiState.collect {
                Log.d("mandyjo 100","...end")
                when(it.status) {
                    Status.ERROR -> {
                        hideProgressBar(binding.root)
                        DialogUtil.getSimpleErrorDialog(requireActivity()).show()
                    }
                    Status.SUCCESS -> {
                        hideProgressBar(binding.root)
                        it.data?.let { data ->
                            if(data.isEmpty()){
                                DialogUtil.getNoDataDialog(requireActivity()).show()
                            } else {
                                binding.actionList.adapter =
                                    MyActionAdapter(data) { id -> navigateToScores(id) }
                            }
                        }

                    }
                    else -> showProgressBar(binding.root)
                }
            }
        }
    }
}
