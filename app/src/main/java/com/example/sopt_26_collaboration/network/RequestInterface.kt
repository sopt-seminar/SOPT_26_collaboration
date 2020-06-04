package com.example.sopt_26_collaboration.network

import com.example.sopt_26_collaboration.data.ResponseContentData
import com.example.sopt_26_collaboration.network.response.ResponseRecommendPeople
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestInterface {

    @GET("/contents/info/0")
    fun requestContentInfo(
        //     @Query("uid") uid : Int

    ): Call<ResponseContentData>

    @GET("/user/recommend/:uid")
    fun getRecommendPeople() : Call<ResponseRecommendPeople>
}