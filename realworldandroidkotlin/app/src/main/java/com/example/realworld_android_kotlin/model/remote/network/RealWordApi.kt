package com.example.realworld_android_kotlin.model.remote.network

import com.example.realworld_android_kotlin.model.data.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*
import kotlin.collections.HashMap

interface RealWordApi {
    @POST(AUTHENTICATION)
    suspend fun login(
        @Body authentication: Authentication
    ): Response<User>

    @POST(REGISTRATION)
    fun register(
        @Field("username") userName: String,
        @Field("email") email: String,
        @Field("password") passwrod: String
    ): Response<User>

    @GET(USER)
    fun getCurrentUser(): Call<User>

    @PUT(USER)
    fun updateUser(
        @Field("username") userName: String,
        @Field("email") email: String,
        @Field("password") passwrod: String,
        @Field("image") image: String,
        @Field("bio") bio: String
    ): Call<User>

    @GET(PROFILE)
    fun getProfile(
        @Path("username") userName: String
    ): Call<Profile>

    @POST(FOLLOW)
    fun followUser(
        @Path("username") userName: String
    ): Call<Profile>

    @DELETE(FOLLOW)
    fun unFollowUser(
        @Path("username") userName: String
    ): Call<Profile>

    @GET(ARTICLES)
    suspend fun getArticles(
        @QueryMap params: HashMap<String, Objects> = hashMapOf(),
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<Articles>

    @GET(FEED)
    fun getFeedArticles(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Call<Articles>

    @GET(ARTICLE)
    fun getArticle(
        @Path("slug") slug: String
    ): Call<Article>


    @POST(ARTICLES)
    fun createArticle(
        @FieldMap params: HashMap<String, Objects>
    ): Call<Article>

    @PUT(ARTICLE)
    fun updateArticle(
        @Path("slug") slug: String,
        @FieldMap params: HashMap<String, Objects>
    ): Call<Article>

    @DELETE(ARTICLE)
    fun deleteArticle(
        @Path("slug") slug: String
    )

    @POST(COMMENTS)
    fun addCommentToArticle(
        @Path("slug") slug: String,
        @Field("body") body: String
    ): Call<Comment>

    @GET(COMMENTS)
    fun getCommentsFromArticle(
        @Path("slug") slug: String
    ): Response<Comments>

    @DELETE(DELETE_COMMENTS)
    fun deleteComment(
        @Path("slug") slug: String,
        @Path("id") id: String
    )

    @POST(FAVORITE_ARTICLE)
    suspend fun postFavoriteArticle(
        @Path("slug") slug: String
    ): Response<Article>

    @DELETE(FAVORITE_ARTICLE)
    suspend fun postUnFavoriteArticle(
        @Path("slug") slug: String
    ): Response<Article>

    @GET(TAGS)
    fun getTags(): Call<Tags>
}