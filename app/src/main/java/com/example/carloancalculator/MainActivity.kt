package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculatePayment()
        }
    }
    private fun calculatePayment(){


        if(editTextCarPrice.text.isEmpty()) {
            editTextCarPrice.setError(getString(R.string.error_input))
        }
        else{
            val carPrice: Int = editTextCarPrice.text.toString().toInt()
            val downPayment:Int=editTextDownPayment.text.toString().toInt()
            val loanPeriod:Int=editLoanPeriod.text.toString().toInt()
            val interestRate:Double=editTextInterestRate.text.toString().toDouble()

            
            val currency=NumberFormat.getCurrencyInstance(resources.configuration.locale)

            val loan=carPrice-downPayment
            val interest=loan*interestRate*loanPeriod
            val monthlyPayment=(loan+interest)/loanPeriod/12

            textViewCarLoan.setText(getString(R.string.loan)+"${currency.format(loan)}")
            textViewInterest.setText(getString(R.string.interest)+"${currency.format(interest)}")
            textViewMonthyRepayment.setText(getString(R.string.monthly_repayment)+"${currency.format(monthlyPayment)}")
        }
    }
    fun reset(view: View){
        editTextCarPrice.setText("")
        editLoanPeriod.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        textViewCarLoan.setText("")
        textViewInterest.setText("")
        textViewMonthyRepayment.setText("")

    }
}
