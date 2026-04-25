package com.app.interviewprepare.viewmodel.savestatehandle

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private var _email = savedStateHandle.get<String>("email") ?: ""
        set(value) {
            field = value
            savedStateHandle["email"] = value
        }

    val email = _email

    private var _password = savedStateHandle.get<String>("password") ?: ""
        set(value) {
            field = value
            savedStateHandle["password"] = value
        }

    val password = _password

    val resultLiveData = savedStateHandle.getLiveData<Result<String>>("result")

    fun isLoginSuccessful() {
        savedStateHandle["result"] = try {
            Result.Loading
            if (_email.isNullOrEmpty()) {
                throw InvalidEmailException("Enter valid email.")
            }
            if (_password.isNullOrEmpty()) {
                throw InvalidPasswordException("Enter valid password.")
            }
            Result.Success("Login Successful")
        } catch (ex: InvalidEmailException) {
            Result.Error(ex)
        } catch (ex: InvalidPasswordException) {
            Result.Error(ex)
        } catch (ex: Exception) {
            Result.Error(Exception("Something went wrong"))
        }
    }

    fun setPassword(_password: String) {
        this._password = _password
    }

    fun setEmail(_email: String) {
        this._email = _email
    }

}