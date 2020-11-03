package com.example.realworld_android_kotlin.model.remote.data

data class Comment(
    val author: Author,
    val body: String,
    val createdAt: String,
    val id: Int,
    val updatedAt: String
)