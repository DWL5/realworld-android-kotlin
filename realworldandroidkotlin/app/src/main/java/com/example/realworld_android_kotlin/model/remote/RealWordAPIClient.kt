package com.example.realworld_android_kotlin.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RealWordAPIClient {
    private var instance : Retrofit? = null

    fun getInstance() : Retrofit {
        if (instance == null) {
            instance = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return instance!!
    }
}