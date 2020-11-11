package com.example.realworld_android_kotlin.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    val author: Author,
    val body: String,
    val createdAt: String,
    val description: String,
    val favorited: Boolean,
    val favoritesCount: Int,
    val slug: String,
    val tagList: List<String>,
    val title: String,
    val updatedAt: String
) : Parcelable