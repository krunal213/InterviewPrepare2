package com.app.interviewprepare.viewmodel.viewmodelfactory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.app.interviewprepare.R

class MainFragmentB : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.viewmodels_fragment_main_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity(),MainViewModelFactory()).get(MainViewModel::class.java)
        view
            .findViewById<Button>(R.id.button)
            .setOnClickListener {
                viewModel.i++
                view.findViewById<TextView>(R.id.textView).text = viewModel.i.toString()
            }


    }

}