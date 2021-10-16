package com.spotify.data.di

import com.spotify.data.store.remote.api.ApiManager
import org.koin.dsl.module

val apiManagerModule = module {
    single {
        ApiManager()
    }
}