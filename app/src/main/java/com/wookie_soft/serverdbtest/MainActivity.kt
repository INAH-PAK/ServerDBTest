package com.wookie_soft.serverdbtest

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.wookie_soft.serverdbtest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    // 레트로핏 기능 구현 테스트 프로젝트 !
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btn.setOnClickListener { clickBtn() }


    }

    fun clickBtn(){
        //Post 방식으로 객체를 서버에 전달하자 !
        var item = ItemModel(1,"inahpakkr@gmail.com","호호홍")

        val retrofit = RetrofitHelper.getRetrofitInstans()
        val retrofitService = retrofit.create(RetrofitService::class.java)
        Log.i("데이터는 잘 들어갔나", item.email +" : "+ item.title)


        //서버로 보낼 값을 가진 call 바로 보내버리기
        val call:Call<ItemModel> = retrofitService.postMethodTest(item)
        call.enqueue( object : Callback<ItemModel> {
            override fun onResponse(call: Call<ItemModel>, response: Response<ItemModel>) {
                //성공시
                item = response.body()!!
                Log.d("log11 잘 ",response.toString())
                Log.d("log 22잘 ", response.body().toString())

                Log.i("서버에 잘 갔나", item.email +" : "+ item.title)

            }

            override fun onFailure(call: Call<ItemModel>, t: Throwable) {
                //실패시
                AlertDialog.Builder(this@MainActivity).setMessage(t.message).create().show()
            }


        })




    }
}