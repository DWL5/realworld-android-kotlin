package com.example.realworld_android_kotlin.model.remote.data

data class Author(
    val bio: String,
    val following: Boolean,
    val image: String,
    val username: String
)