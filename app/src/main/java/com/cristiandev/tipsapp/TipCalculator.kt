package com.cristiandev.tipsapp

class TipCalculator() {

    fun calculateTip(serviceCost: String,  roundUp: Boolean, rgTipOptions:Int): Double {
        val tipPercentage = when (rgTipOptions) {
            R.id.rbTwentyPercentOption -> 0.20
            R.id.rbEighteenPercentOption -> 0.18
            else -> 0.15
        }
        val tip:Double = if (roundUp) {
            kotlin.math.ceil(serviceCost.toDouble() * tipPercentage)
        } else {
            serviceCost.toDouble() * tipPercentage
        }
        return tip
    }
}