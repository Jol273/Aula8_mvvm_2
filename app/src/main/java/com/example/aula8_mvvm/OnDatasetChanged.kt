package com.example.aula8_mvvm

import com.example.aula8_mvvm.classes.Operation

interface OnDatasetChanged {
    fun onDatasetChanged(value: List<Operation>?)
}