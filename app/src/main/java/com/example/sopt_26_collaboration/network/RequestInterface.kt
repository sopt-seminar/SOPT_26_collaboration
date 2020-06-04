package com.example.sopt_26_collaboration.network

import com.example.sopt_26_collaboration.data.ResponseContentData
import com.example.sopt_26_collaboration.data.ResponseHeartData
import com.example.sopt_26_collaboration.data.ResponseRecruitData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RequestInterface {

    @GET("/contents/info/0" )
    fun requestContentInfo(
   //     @Query("uid") uid : Int

    ) : Call<ResponseContentData>

    @GET("/company/interested/0")
    fun requestRecruitInfo() : Call<ResponseRecruitData>

    @PUT("/company/hearts/{idx}/{hearts}")
    fun requestHeartUpdate(@Path("idx") company_idx :Int, @Path("hearts") company_hearts :Int) :Call<ResponseHeartData>
}