package com.myapplication.cyptoapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myapplication.cyptoapp.Model.CyptroDataClass
import com.myapplication.cyptoapp.Repository.CyptroRepository
import kotlin.reflect.KProperty

class CoinsViewModel:ViewModel() {

    private var cyptroRepository: CyptroRepository

    var cytroList: LiveData<CyptroDataClass>? = null


    init {
        cyptroRepository = CyptroRepository().getretrofitinstance()

    }

    fun getcoinname(coin_name: String): LiveData<CyptroDataClass> {
        cytroList = cyptroRepository.getCoinData(coin_name)
        return cytroList!!
    }


}
