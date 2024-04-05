package com.guidomia.app

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.guidomia.app.model.CarModel
import com.guidomia.app.util.getJsonDataFromAsset
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _carList = MutableStateFlow<List<CarModel>>(emptyList())
    val carList: StateFlow<List<CarModel>> get() = _carList


    fun loadCarsFromJsonFile(context: Context, fileName: String) {
        val cars = getCarList(context, fileName)
        _carList.value = cars
    }

    private fun getCarList(context: Context, fileName: String): List<CarModel> {
        val jsonFileString = getJsonDataFromAsset(context, fileName)
        val type = object : TypeToken<List<CarModel>>() {}.type
        return Gson().fromJson(jsonFileString, type)
    }
}