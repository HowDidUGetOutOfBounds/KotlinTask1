package com.rsschool.android2021.presenter

import com.github.terrakok.cicerone.Router
import com.rsschool.android2021.general.MyApplication
import com.rsschool.android2021.general.Screens

class SimplePresenter(private val router: Router) {

    fun goToNumberScreen(min: Int, max: Int) {
        router.navigateTo(Screens.NumberScreen(min, max))
    }

    fun goToInputScreen(previousNumber : Int) {
       router.navigateTo(Screens.BoundsInputsScreen(previousNumber))
    }

    fun onBackPressed() {
        router.exit()
    }
}