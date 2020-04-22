package com.example.aula8_mvvm.storage

import com.example.aula8_mvvm.OnDatasetChanged
import com.example.aula8_mvvm.classes.Operation

class ListStorage {

    private var datasetListener: OnDatasetChanged? = null

    private val storage = mutableListOf<Operation>(
       // Operation("1+1", 2.0),
       // Operation("2+3", 5.0)
    )


    companion object{
        private var instance: ListStorage? = null

        fun getInstance(): ListStorage {
            synchronized(this){
                if (instance == null){
                    instance =
                        ListStorage()
                }
                return instance as ListStorage
            }
        }
    }

    //suspend
    fun insert(operation: Operation){
        //withContext(Dispatchers.IO){
            //Thread.sleep(1000)
            storage.add(operation)
        notifyOnDatasetChanged()
        //}
    }

    //suspend
    fun getAll() : List<Operation>{
        //withContext(Dispatchers.IO) {Thread.sleep(1000)}
        notifyOnDatasetChanged()
        return storage.toList()
    }

    //suspend
    fun delete(operation: Operation){
        /*withContext(Dispatchers.IO){
            Thread.sleep(1000)
        }*/
        storage.remove(operation)
        notifyOnDatasetChanged()
    }

    fun getLastExpression(): String{
        return storage[storage.size-1].expresssion
    }

    private fun notifyOnDatasetChanged() {datasetListener?.onDatasetChanged(storage)}

    fun unregisterDatasetListener(){datasetListener = null}

    fun registerDatasetListener(datasetListener: OnDatasetChanged){
        this.datasetListener = datasetListener
        datasetListener.onDatasetChanged(storage)
    }
}