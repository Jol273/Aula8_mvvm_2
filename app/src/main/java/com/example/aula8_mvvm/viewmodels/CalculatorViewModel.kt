package com.example.aula8_mvvm.viewmodels

import androidx.lifecycle.ViewModel
import com.example.aula8_mvvm.OnDisplayChanged
import com.example.aula8_mvvm.logics.CalculatorLogic

class CalculatorViewModel : ViewModel() {

    private val calculatorLogic = CalculatorLogic()
    var display: String = "0"

    private var displayListener: OnDisplayChanged? = null
    
    private fun notifyOnDisplayChanged(){ displayListener?.onDisplayChanged(display) }

    fun registerDisplayListener(displayListener: OnDisplayChanged){
        this.displayListener = displayListener
        displayListener.onDisplayChanged(display)
    }

    fun unregisterDisplayListener(){ displayListener = null }

    fun onClickSymbol(symbol: String) {
        display = calculatorLogic.insertSymbol(display,symbol)
        notifyOnDisplayChanged()
    }

    fun onClickEquals(){
        display = calculatorLogic.performOperation(display).toString()
        notifyOnDisplayChanged()
    }

    fun onClickBackspace(){
        display = calculatorLogic.performBackspace(display)
        notifyOnDisplayChanged()
    }

    fun onClickClear(){
        display = calculatorLogic.performOperationClear()
        notifyOnDisplayChanged()
    }
    
    fun onClickLastExpression(){
        display = calculatorLogic.getLastExpression()
        notifyOnDisplayChanged()
    }

}