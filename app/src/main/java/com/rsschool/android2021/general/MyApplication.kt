package com.rsschool.android2021.general

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.rsschool.android2021.presenter.SimplePresenter

class MyApplication : Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val presenter = SimplePresenter(router)


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object{
        internal lateinit var INSTANCE: MyApplication
            private set
    }
}