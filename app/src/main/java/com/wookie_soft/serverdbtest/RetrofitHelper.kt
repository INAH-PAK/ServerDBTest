package com.wookie_soft.serverdbtest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {
    companion object{
        fun getRetrofitInstans():Retrofit{

            val builder = Retrofit.Builder()
            builder.baseUrl("http://plogging.dothome.co.kr")
            builder.addConverterFactory(GsonConverterFactory.create())
            val retrofit = builder.build()

            return retrofit
        }
    }
}