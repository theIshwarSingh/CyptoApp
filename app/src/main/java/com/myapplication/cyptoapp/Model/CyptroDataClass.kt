package com.myapplication.cyptoapp.Model

import com.google.gson.annotations.SerializedName

data class CyptroDataClass (

    @SerializedName("ticker") var ticker:TickerDataClass,
    @SerializedName("timestamp") var timestamp:String,
    @SerializedName("success") var success:String,
    @SerializedName("error") var error:String
)


