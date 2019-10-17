package com.myapplication.cyptoapp.Model

import com.google.gson.annotations.SerializedName

data class TickerDataClass(
    @SerializedName("base") var base:String,
    @SerializedName("target") var target:String,
    @SerializedName("price") var price:String,
    @SerializedName("volume") var volume:String,
    @SerializedName("change") var change:String,
    @SerializedName("markets") var markets:ArrayList<MarketDataClass>? = null
)