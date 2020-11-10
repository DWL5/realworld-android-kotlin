package com.example.realworld_android_kotlin.view.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.realworld_android_kotlin.model.repository.RealWorldRepository

class LoginViewModel @ViewModelInject constructor(
    private val repository: RealWorldRepository
) : ViewModel() {
    private val TAG = LoginViewModel::class.simpleName

    fun signIn(email: String, pw: String)  = repository.signIn(email, pw)

    fun isPasswordValid(pw: String): Boolean {
        return pw != null && pw.length >= 8
    }

    fun isEmailValid(email: String): Boolean {
        if (email.isNotEmpty()) return false
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}