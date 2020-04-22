package com.example.aula8_mvvm.viewmodels

import androidx.lifecycle.ViewModel
import com.example.aula8_mvvm.OnDatasetChanged
import com.example.aula8_mvvm.classes.Operation
import com.example.aula8_mvvm.storage.ListStorage

class HistoryViewModel : ViewModel(){

    private val storage = ListStorage.getInstance()
    private val historic: List<Operation>? = null

}