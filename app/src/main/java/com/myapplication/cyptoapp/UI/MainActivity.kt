package com.myapplication.cyptoapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.myapplication.cyptoapp.Model.CyptroDataClass
import com.myapplication.cyptoapp.R
import com.myapplication.cyptoapp.Repository.CyptroRepository
import com.myapplication.cyptoapp.ViewModel.CoinsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var coinsViewModel:CoinsViewModel
    private lateinit var coinName:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coinsViewModel = ViewModelProviders.of(this).get(CoinsViewModel::class.java)

        init()
    }

    private fun init() {
        btn.setOnClickListener {
            var coinobserver = Observer<CyptroDataClass>{ newcoin->
                tv_details.text = "$newcoin"
            }
            coinName= et_search_coin.text.toString()
            coinsViewModel.getcoinname(coinName).observe(this@MainActivity, coinobserver)
        }
    }


}
