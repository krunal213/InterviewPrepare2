package com.app.interviewprepare.viewmodel.savestatehandle

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.app.interviewprepare.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.save_state_handle_activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<TextInputEditText>(R.id.textInputEditTextEmail).apply {
            setText(viewModel.email)
            addTextChangedListener(object :
                TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    viewModel.setEmail(s.toString())
                }

                override fun afterTextChanged(s: Editable?) {

                }
            })
        }
        findViewById<TextInputEditText>(R.id.textInputEditTextPassword).apply {
            setText(viewModel.password)
            addTextChangedListener(
                object : TextWatcher {
                    override fun beforeTextChanged(
                        s: CharSequence?,
                        start: Int,
                        count: Int,
                        after: Int
                    ) {

                    }

                    override fun onTextChanged(
                        s: CharSequence?,
                        start: Int,
                        before: Int,
                        count: Int
                    ) {
                        viewModel.setPassword(s.toString())
                    }

                    override fun afterTextChanged(s: Editable?) {

                    }

                })
        }
        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            viewModel.isLoginSuccessful()
        }
        viewModel.resultLiveData.observe(this) {
            when (it) {
                is Result.Loading -> {
                    println("Loading")
                }

                is Result.Success -> {
                    println(it.data)
                }

                is Result.Error -> {
                    when (it.exception) {
                        is InvalidEmailException -> {
                            findViewById<TextInputLayout>(R.id.textInputLayoutEmail).setError(it.exception.message)
                        }

                        is InvalidPasswordException -> {
                            findViewById<TextInputLayout>(R.id.textInputLayoutPassword).setError(it.exception.message)
                        }
                    }
                }
            }
        }

    }
}