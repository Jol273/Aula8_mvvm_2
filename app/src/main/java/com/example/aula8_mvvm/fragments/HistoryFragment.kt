package com.example.aula8_mvvm.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aula8_mvvm.*
import com.example.aula8_mvvm.adapters.HistoryAdapter
import com.example.aula8_mvvm.classes.Operation
import com.example.aula8_mvvm.storage.ListStorage
import com.example.aula8_mvvm.viewmodels.HistoryViewModel
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : Fragment(),OnDatasetChanged {

    //private var operations = ListStorage.getInstance().getAll()
    private var historyViewModel : HistoryViewModel? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onStart() {
        historyViewModel?.registerDatasetListener(this)
        list_history.layoutManager = LinearLayoutManager(activity as Context)
        list_history.adapter = historyViewModel?.historic?.let {
            HistoryAdapter(
                activity as Context,
                R.layout.item_expression,
                it
            )
        }
        super.onStart()
    }

    override fun onDatasetChanged(value: List<Operation>?) {
        value?.let{
            list_history.layoutManager = LinearLayoutManager(activity as Context)
            list_history.adapter = HistoryAdapter(
                activity as Context,
                R.layout.item_expression,
                it
            )
        }
    }

    override fun onDestroy() {
        historyViewModel?.unregisterDatasetListener()
        super.onDestroy()
    }



}

