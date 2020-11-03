package com.example.realworld_android_kotlin.model.remote.data

data class Profile(
    val bio: String,
    val following: Boolean,
    val image: String,
    val username: String
)