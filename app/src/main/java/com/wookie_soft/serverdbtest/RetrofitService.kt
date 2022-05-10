package com.wookie_soft.serverdbtest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST("TestPlogging/insertDB.php")
    fun postMethodTest(@Body itemModel:ItemModel): Call<ItemModel>

}