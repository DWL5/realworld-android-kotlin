package com.example.realworld_android_kotlin.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Author(
    val bio: String,
    val following: Boolean,
    val image: String,
    val username: String
) : Parcelable