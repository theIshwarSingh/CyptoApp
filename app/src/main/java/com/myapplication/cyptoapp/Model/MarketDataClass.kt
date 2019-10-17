package com.myapplication.cyptoapp.Model

import com.google.gson.annotations.SerializedName


data class MarketDataClass(
    @SerializedName("market") var market:String,
    @SerializedName("price") var price:String,
    @SerializedName("volume") var volume:Float,
    var coinName:String

)