package com.shubham.dynamicui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.shubham.dynamicui.model.Data
import com.shubham.dynamicui.model.form
import com.shubham.dynamicui.utils.Utils

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val uiData = MutableLiveData<form>()
    val data = MutableLiveData<List<Data>>()
    private val jsonFileString = Utils().getJsonDataFromAsset(getApplication(), "data.json")
    private val gson = Gson()

    init {
        uiData.value = gson.fromJson(jsonFileString, form::class.java)
        data.value = uiData.value?.data
    }


}