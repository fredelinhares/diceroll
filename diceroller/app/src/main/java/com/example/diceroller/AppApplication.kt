package com.example.diceroller

import android.app.Application
import com.example.diceroller.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(
                AppModule.getModules()
            )
        }
    }
}