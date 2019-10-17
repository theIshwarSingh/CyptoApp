package com.myapplication.cyptoapp.Repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

import com.myapplication.cyptoapp.Model.CyptroDataClass
import com.myapplication.cyptoapp.Model.MarketDataClass
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class CyptroRepository {


    private val BASE_URL: String = "https://api.cryptonator.com/api/full/"

    private val cytroService: Cytro_Service

    private var cytroRepository: CyptroRepository? = null
    var coinsdata = MutableLiveData<CyptroDataClass>()


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()


        cytroService = retrofit.create(Cytro_Service::class.java)
    }

    fun getretrofitinstance(): CyptroRepository {
        if (cytroRepository == null) {
            cytroRepository = CyptroRepository()
        }
        return cytroRepository!!
    }


//    fun getCoinData(coin_name: String) {
//
//        cytroService.getCoin(coin_name).enqueue(object : Callback<CyptroDataClass> {
//            override fun onFailure(call: Call<CyptroDataClass>, t: Throwable) {
//                Log.d("Retrofit", t.message)
//            }
//
//            override fun onResponse(
//                call: Call<CyptroDataClass>, response: Response<CyptroDataClass>
//            ) {
//                coinsdata.value = response.body()
//                Log.d("Retrofit" , response.body().toString() )
//            }
//        })
//            return coinsdata
//    }

    fun getCoinData(coin_name: String): LiveData<CyptroDataClass> {

        cytroService.getCoin(coin_name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(coinlist())
        return  coinsdata
    }

    private fun coinlist(): io.reactivex.Observer<CyptroDataClass> {
        return object: io.reactivex.Observer<CyptroDataClass>{
            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: CyptroDataClass) {
                coinsdata.value = t
                Log.d("data",coinsdata.value.toString())
//                var marketlist:ArrayList<MarketDataClass>



            }

            override fun onError(e: Throwable) {

            }

        }

    }


}





