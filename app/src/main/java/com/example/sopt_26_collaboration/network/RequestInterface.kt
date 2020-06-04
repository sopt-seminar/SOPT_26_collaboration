package com.example.sopt_26_collaboration.network

import com.example.sopt_26_collaboration.RecommendPeople
import com.example.sopt_26_collaboration.network.response.CompanyResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface RequestInterface {

    @GET("/user/recommend/:uid")
    fun getRecommendPeople(@Body body: RecommendPeople) : Call<RecommendPeople>

    @GET("/company/popular/:uid")
    fun getPopularCompany() : Call<CompanyResponse>
}