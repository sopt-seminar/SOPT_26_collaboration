package com.example.sopt_26_collaboration.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RequestToServer {
    var retrofit = Retrofit.Builder()
        .baseUrl("http://52.79.151.21:3000") .addConverterFactory(GsonConverterFactory.create()) .build()
    var service: RequestInterface = retrofit.create(RequestInterface::class.java)
}