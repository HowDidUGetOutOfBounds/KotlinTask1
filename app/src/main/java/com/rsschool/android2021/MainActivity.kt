package com.rsschool.android2021

import androidx.appcompat.app.AppCompatActivity
import com.rsschool.android2021.FirstFragment.OnFragmentSendDataListener
import com.rsschool.android2021.SecondFragment.OnFragmentBackDataListener
import android.os.Bundle
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.rsschool.android2021.general.MyApplication
import com.rsschool.android2021.general.Screens.BoundsInputsScreen
import com.rsschool.android2021.presenter.SimplePresenter
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity(), OnFragmentSendDataListener, OnFragmentBackDataListener {


    private val navigator: Navigator = object : AppNavigator(this, R.id.container) {
        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    val navigatorHolder: NavigatorHolder by inject()
    val presenter: SimplePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator.applyCommands(arrayOf<Command>(Replace(BoundsInputsScreen(0))))
    }


    override fun onSendData(min: Int, max: Int) {
        presenter.goToNumberScreen(min, max)
    }

    override fun onBackData(random: Int) {
        //navigator.applyCommands(arrayOf<Command>(Replace(BoundsInputsScreen(random))))
        //openFirstFragment(random)
        presenter.goToInputScreen(random)
    }

    //oh god! DO NOT do like this! Correct solution will be create ViewModel and store shared data there
    override fun onBackPressed() {
        val fragmentStackCount =
            supportFragmentManager.fragments.size
        if (fragmentStackCount > 0) {
            if(supportFragmentManager.fragments[0] is SecondFragment)
            {
            presenter.goToInputScreen((supportFragmentManager.fragments[0] as SecondFragment).randomValue)
            }
        } else {
           presenter.onBackPressed()
        }

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}