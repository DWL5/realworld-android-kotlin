package com.example.realworld_android_kotlin.model.repository

import androidx.lifecycle.LiveData
import com.example.realworld_android_kotlin.model.remote.Resource
import com.example.realworld_android_kotlin.model.data.*

import kotlin.collections.HashMap

interface RealWorldRepository {
    fun signIn(email: String, password: String): LiveData<Resource<User>>
    fun signUp(email: String, password: String, userName: String): User
    fun getCurrentUser(): User
    fun updateUser(user: User): User

    fun getUserProfile(userName: String): Profile
    fun followUser(userName: String): Profile
    fun unFollowUser(userName: String): Profile

    fun getArticles(option: HashMap<String, Object>): Articles
    fun getFeedArticles(): Articles
    fun getArticle(slug: String): Article
    fun createArticle(article: Article): Article
    fun updateArticle(article: Article): Article
    fun deleteArticle(article: Article)

    fun addCommentToArticle(article: Article, body: String): Comment
    fun getCommentsFromArticle(slug: String):  LiveData<Resource<Comments>>
    fun deleteComment(article: Article, comment: Comment)

    fun favoriteArticle(article: Article)
    fun unFavoriteArticle(article: Article)

    fun getTags():Tags


}