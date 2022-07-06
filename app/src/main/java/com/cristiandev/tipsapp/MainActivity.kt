package com.cristiandev.tipsapp

import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cristiandev.tipsapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var serviceCost: String
    private var roundUp: Boolean = false
    private var rgTipOptions: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateTip.setOnClickListener {
            setVariables()
            printTipResult()
        }
    }

    private fun printTipResult() {
        if (serviceCost.isNotEmpty()) {
            val tipCalculator = TipCalculator()
            val tipResult: Double = tipCalculator.calculateTip(serviceCost, roundUp, rgTipOptions)
            val formattedTip = NumberFormat.getCurrencyInstance().format(tipResult)
            binding.tvTipAmount.text = getString(R.string.tip_amount, formattedTip)
        } else {
            Toast
                .makeText(this, "Please enter a service cost!", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun setVariables() {
        serviceCost = binding.etCostOfService.text.toString()
        roundUp = binding.swRoundUp.isChecked
        rgTipOptions = binding.rgTipOptions.checkedRadioButtonId
    }
}