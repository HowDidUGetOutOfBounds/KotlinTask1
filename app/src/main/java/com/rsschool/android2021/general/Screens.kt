package com.rsschool.android2021.general

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.rsschool.android2021.FirstFragment
import com.rsschool.android2021.R
import com.rsschool.android2021.SecondFragment

object Screens {
    fun BoundsInputsScreen(previousNumber: Int) = FragmentScreen {
        FirstFragment.newInstance(previousNumber)
    }

    fun NumberScreen(min: Int, max: Int) = FragmentScreen {
        SecondFragment.newInstance(min, max)
    }
}