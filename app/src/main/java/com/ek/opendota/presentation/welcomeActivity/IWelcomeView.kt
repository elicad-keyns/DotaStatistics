package com.ek.opendota.presentation.welcomeActivity

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface IWelcomeView: MvpView {
}