package com.example.sopt_26_collaboration.network

import com.example.sopt_26_collaboration.RecommendPeople
import com.example.sopt_26_collaboration.data.ResponseContentData
import com.example.sopt_26_collaboration.network.response.CompanyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface RequestInterface {

    @GET("/contents/info/0" )
    fun requestContentInfo(
   //     @Query("uid") uid : Int

    ) : Call<ResponseContentData>

    @GET("/user/recommend/:uid")
    fun getRecommendPeople(@Body body: RecommendPeople) : Call<RecommendPeople>

    @GET("/company/popular/:uid")
    fun getPopularCompany() : Call<CompanyResponse>
}