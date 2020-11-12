package com.example.realworld_android_kotlin.di

import com.example.realworld_android_kotlin.MainApplication
import com.example.realworld_android_kotlin.model.remote.network.BASE_URL
import com.example.realworld_android_kotlin.model.remote.RemoteDataSource
import com.example.realworld_android_kotlin.model.remote.RemoteDataSourceImpl
import com.example.realworld_android_kotlin.model.remote.RemoteGlobalFeedPagingSource
import com.example.realworld_android_kotlin.model.remote.network.RealWordApi
import com.example.realworld_android_kotlin.model.repository.RealWorldRepository
import com.example.realworld_android_kotlin.model.repository.RealWorldRepositoryImpl
import com.example.realworld_android_kotlin.utils.KEY_AUTH_TOKEN
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideInterceptor() = Interceptor { chain ->
        val token = MainApplication.pref.getString(KEY_AUTH_TOKEN, "")
        if (token != null && token != "") {
            val newRequest = chain.request().newBuilder().addHeader("Authorization", token).build()
            chain.proceed(newRequest)
        } else {
            val newRequest = chain.request()
            chain.proceed(newRequest)
        }
    }


    @Singleton
    @Provides
    fun provideOkHttp(interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    fun provideRealWorldService(retrofit: Retrofit): RealWordApi = retrofit.create(
        RealWordApi::class.java
    )

    @Provides
    fun provideRemoteGlobalFeedPagingSource(realWordApi: RealWordApi): RemoteGlobalFeedPagingSource =
        RemoteGlobalFeedPagingSource(realWordApi)

}

@Module
@InstallIn(ApplicationComponent::class)
abstract class BindModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Singleton
    @Binds
    abstract fun bindRepository(repositoryImpl: RealWorldRepositoryImpl): RealWorldRepository
}