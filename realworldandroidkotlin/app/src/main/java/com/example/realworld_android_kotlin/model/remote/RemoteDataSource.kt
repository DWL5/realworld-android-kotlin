package com.example.realworld_android_kotlin.model.remote

import com.example.realworld_android_kotlin.model.data.*

interface RemoteDataSource {
    suspend fun signIn(email: String, password: String): Resource<User>
    suspend fun signUp(email: String, password: String, userName: String): Resource<User>
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
    suspend fun getCommentsFromArticle(slug: String): Resource<Comments>
    fun deleteComment(article: Article, comment: Comment)

    suspend fun favoriteArticle(slug: String) : Resource<Article>
    suspend fun unFavoriteArticle(slug: String) : Resource<Article>

    fun getTags(): Tags
}