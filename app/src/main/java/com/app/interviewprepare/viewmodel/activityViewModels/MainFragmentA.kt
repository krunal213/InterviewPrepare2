package com.app.interviewprepare.viewmodel.activityViewModels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.app.interviewprepare.R

class MainFragmentA : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_viewmodels_fragment_main_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view
            .findViewById<Button>(R.id.button)
            .setOnClickListener {
                viewModel.a++
                view.findViewById<TextView>(R.id.textView).text = viewModel.a.toString()
            }


    }

}