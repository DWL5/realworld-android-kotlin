package com.example.realworld_android_kotlin.view.login

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.realworld_android_kotlin.model.remote.Resource
import com.example.realworld_android_kotlin.model.remote.data.User
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