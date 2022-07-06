package com.cristiandev.tipsapp

const val AMAZING_OPTION_PERCENT: Double = 0.20
const val GOOD_OPTION_PERCENT: Double = 0.18
const val OK_OPTION_PERCENT: Double = 0.15

class TipCalculator() {

    fun calculateTip(serviceCost: String,  roundUp: Boolean, rgTipOptions:Int): Double {
        val tipPercentage = when (rgTipOptions) {
            R.id.rbAmazingOption -> AMAZING_OPTION_PERCENT
            R.id.rbGoodOption -> GOOD_OPTION_PERCENT
            else -> OK_OPTION_PERCENT
        }
        val tip:Double = if (roundUp) {
            kotlin.math.ceil(serviceCost.toDouble() * tipPercentage)
        } else {
            serviceCost.toDouble() * tipPercentage
        }
        return tip
    }
}