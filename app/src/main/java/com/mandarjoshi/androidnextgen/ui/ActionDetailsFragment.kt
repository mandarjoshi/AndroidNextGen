package com.mandarjoshi.androidnextgen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.mandarjoshi.androidnextgen.viewmodel.ActionViewModel
import com.mandarjoshi.androidnextgen.viewmodel.ViewModelFactory

import javax.inject.Inject
import com.mandarjoshi.androidnextgen.AndroidNextGenApplication

import com.mandarjoshi.androidnextgen.R
import com.mandarjoshi.androidnextgen.databinding.FragmentActionDetailsBinding
import com.mandarjoshi.androidnextgen.util.Constants


class ActionDetailsFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val mViewModel: ActionViewModel by activityViewModels { viewModelFactory }

    private lateinit var id: String
    private lateinit var binding: FragmentActionDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().applicationContext as AndroidNextGenApplication).appComponent.inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_action_details, container, false)
        arguments?.getString(Constants.ACTION_ID_KEY)?.let {
            id = it
        }
        binding.viewModel = mViewModel
        return binding.root
    }

}
