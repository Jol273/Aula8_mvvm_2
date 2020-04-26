package com.example.aula8_mvvm.viewmodels

import androidx.lifecycle.ViewModel
import com.example.aula8_mvvm.OnDatasetChanged
import com.example.aula8_mvvm.classes.Operation
import com.example.aula8_mvvm.storage.ListStorage

class HistoryViewModel : ViewModel(){

    private val storage = ListStorage.getInstance()
    var historic: List<Operation>? = null

    private var datasetListener: OnDatasetChanged? = null

    private fun notifyOnDatasetChanged(){datasetListener?.onDatasetChanged(historic)}

    fun registerDatasetListener(displayListener: OnDatasetChanged){
        this.datasetListener = displayListener
        displayListener.onDatasetChanged(historic)
    }

    fun unregisterDatasetListener(){ datasetListener = null }

    private suspend fun getAll(){
        historic = storage.getAll()
        notifyOnDatasetChanged()
    }
}