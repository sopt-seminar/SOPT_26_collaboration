package com.example.sopt_26_collaboration.network.response

import com.example.sopt_26_collaboration.RecommendPeople

data class ResponseRecommendPeople(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<RecommendPeople>
)