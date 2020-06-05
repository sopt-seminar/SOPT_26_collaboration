package com.example.sopt_26_collaboration.network

import com.example.sopt_26_collaboration.RecommendPeople
import com.example.sopt_26_collaboration.data.ResponseContentData
import com.example.sopt_26_collaboration.network.response.ResponsePopularCompany
import com.example.sopt_26_collaboration.network.response.ResponseFollowData
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface {

    @GET("/contents/info/0")
    fun requestContentInfo(
        //     @Query("uid") uid : Int

    ): Call<ResponseContentData>

    @GET("/user/recommend/:uid")
    fun getRecommendPeople(@Body body: RecommendPeople): Call<RecommendPeople>

    @GET("/company/popular/0")
    fun requestPopularCompany(): Call<ResponsePopularCompany>

    @Headers("Content-Type:application/json")
    @PUT("/company/following/{company_idx}/{company_follow}")
    fun requestPutFollow(
        @Path("company_idx") company_idx: Int,
        @Path("company_follow") company_follow: Int
    ): Call<ResponseFollowData>
}