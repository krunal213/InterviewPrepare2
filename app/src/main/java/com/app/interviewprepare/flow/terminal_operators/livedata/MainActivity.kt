package com.app.interviewprepare.flow.terminal_operators.livedata

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.app.interviewprepare.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_terminal_operator_livedata)
        val mainViewModel = MainViewModel()
        val textView2 = findViewById<TextView>(R.id.textView2)
        mainViewModel.data.observe(this){
            textView2.append(it.toString()+"\n")
        }
    }
}