package com.example.realworld_android_kotlin.di

import com.example.realworld_android_kotlin.model.remote.BASE_URL
import com.example.realworld_android_kotlin.model.remote.RemoteDataSource
import com.example.realworld_android_kotlin.model.remote.RemoteDataSourceImpl
import com.example.realworld_android_kotlin.model.remote.network.RealWordApi
import com.example.realworld_android_kotlin.model.repository.RealWorldRepository
import com.example.realworld_android_kotlin.model.repository.RealWorldRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideRealWorldService(retrofit: Retrofit): RealWordApi = retrofit.create(
            RealWordApi::class.java)

}

@Module
@InstallIn(ApplicationComponent::class)
abstract class BindModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Singleton
    @Binds
    abstract fun bindRepository(repositoryImpl: RealWorldRepositoryImpl) : RealWorldRepository
}