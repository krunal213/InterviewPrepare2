package com.app.interviewprepare.viewmodel.viewmodels

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.app.interviewprepare.R

class MainFragmentB : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.viewmodels_fragment_main_b, container, false)
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