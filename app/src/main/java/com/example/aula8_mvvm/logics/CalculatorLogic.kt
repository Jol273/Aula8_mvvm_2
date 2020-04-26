package com.example.aula8_mvvm.logics

import com.example.aula8_mvvm.classes.Operation
import com.example.aula8_mvvm.storage.ListStorage
import kotlinx.coroutines.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.FieldPosition

class CalculatorLogic {

    private val storage = ListStorage.getInstance()
    private var lastExpression : String =""

    fun insertSymbol(display: String, symbol: String): String{
        return if(display.isEmpty() && symbol == "0") symbol else display + symbol
    }

    fun performOperation(expression : String): Double {
        lastExpression = expression
        val expressionBuilder = ExpressionBuilder(expression).build()
        val result = expressionBuilder.evaluate()
        CoroutineScope(Dispatchers.IO).launch {
            storage.insert(
                Operation(expression, result)
            )
        }
        return result
    }

    fun performBackspace(display: String): String{
        return display.dropLast(1)
    }

    fun performOperationClear(): String{
        return "0"
    }

    fun getLastExpression(): String{
        return lastExpression
    }

    suspend fun onLongClick(item: Operation){
        storage.delete(item)
    }

}