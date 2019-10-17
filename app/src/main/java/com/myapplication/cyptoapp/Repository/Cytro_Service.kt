package com.myapplication.cyptoapp.Repository

import com.myapplication.cyptoapp.Model.CyptroDataClass
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

interface Cytro_Service {

    @GET("{coin}-usd")
    fun getCoin(@Path("coin") coin:String): Observable<CyptroDataClass>
}