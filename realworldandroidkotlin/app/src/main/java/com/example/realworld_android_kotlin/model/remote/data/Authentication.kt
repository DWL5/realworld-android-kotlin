package com.example.realworld_android_kotlin.model.remote.data

data class Authentication(
    val user: User
) {
    data class User(
        val email: String,
        val password: String
    )
}

