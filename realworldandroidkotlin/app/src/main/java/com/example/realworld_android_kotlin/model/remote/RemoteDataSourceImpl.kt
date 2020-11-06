package com.example.realworld_android_kotlin.model.remote

import com.example.realworld_android_kotlin.model.remote.data.*
import com.example.realworld_android_kotlin.model.remote.network.RealWordApi
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val realWordService: RealWordApi
) : RemoteDataSource, BaseRemoteDataSource() {

    override suspend fun signIn(email: String, password: String) =
        getResult { realWordService.login(email, password) }

    override suspend fun signUp(email: String, password: String, userName: String) =
        getResult { realWordService.register(userName = userName, email = email, passwrod = password) }


    override fun getCurrentUser(): User {
        TODO("Not yet implemented")
    }

    override fun updateUser(user: User): User {
        TODO("Not yet implemented")
    }

    override fun getUserProfile(userName: String): Profile {
        TODO("Not yet implemented")
    }

    override fun followUser(userName: String): Profile {
        TODO("Not yet implemented")
    }

    override fun unFollowUser(userName: String): Profile {
        TODO("Not yet implemented")
    }

    override fun getArticles(option: HashMap<String, Object>): Articles {
        TODO("Not yet implemented")
    }

    override fun getFeedArticles(): Articles {
        TODO("Not yet implemented")
    }

    override fun getArticle(slug: String): Article {
        TODO("Not yet implemented")
    }

    override fun createArticle(article: Article): Article {
        TODO("Not yet implemented")
    }

    override fun updateArticle(article: Article): Article {
        TODO("Not yet implemented")
    }

    override fun deleteArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun addCommentToArticle(article: Article, body: String): Comment {
        TODO("Not yet implemented")
    }

    override fun getCommentsFromArticle(article: Article): Comments {
        TODO("Not yet implemented")
    }

    override fun deleteComment(article: Article, comment: Comment) {
        TODO("Not yet implemented")
    }

    override fun favoriteArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun unFavoriteArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getTags(): Tags {
        TODO("Not yet implemented")
    }
}