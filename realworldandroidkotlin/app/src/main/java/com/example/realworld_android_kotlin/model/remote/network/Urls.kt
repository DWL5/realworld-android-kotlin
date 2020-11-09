package com.example.realworld_android_kotlin.model.remote.network

const val BASE_URL = "https://conduit.productionready.io/api/"
const val AUTHENTICATION = "api/users/login"
const val REGISTRATION = "api/users"
const val USER = "api/user"
const val PROFILE = "api/profiles/{username}"
const val FOLLOW = "api/profiles/{username}/follow"
const val ARTICLE = "api/articles/{slug}"
const val ARTICLES = "api/articles"
const val FEED = "api/articles/feed"
const val COMMENTS = "api/articles/{slug}/comments"
const val DELETE_COMMENTS = "api/articles/{slug}/comments/{id}"
const val FAVORITE_ARTICLE = "api/articles/{slug}/favorite"
const val TAGS = "api/tags"