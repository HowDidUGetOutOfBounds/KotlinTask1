package com.rsschool.android2021.DI

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.rsschool.android2021.presenter.SimplePresenter
import org.koin.dsl.module

val appModule = module {
    single<Cicerone<Router>> { Cicerone.create() }
    single<Router> { get<Cicerone<Router>>().router}
    single<NavigatorHolder> { get<Cicerone<Router>>().getNavigatorHolder()}
    single<SimplePresenter> { SimplePresenter(get()) }
}