package com.spotify

import android.app.Application
import com.spotify.data.di.apiManagerModule
import com.spotify.data.di.repoModule
import com.spotify.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repoModule, viewModelModule, apiManagerModule))
        }
    }
}