package com.rsschool.android2021.general

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.rsschool.android2021.DI.appModule
import com.rsschool.android2021.presenter.SimplePresenter
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }

}