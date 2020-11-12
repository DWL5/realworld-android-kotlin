package com.example.realworld_android_kotlin

import android.app.Application
import android.content.SharedPreferences
import com.example.realworld_android_kotlin.utils.SharedPreferenceUtil
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application() {
    companion object {
        lateinit var pref: SharedPreferenceUtil
    }

    override fun onCreate() {
        super.onCreate()
        pref = SharedPreferenceUtil(this)
    }
}