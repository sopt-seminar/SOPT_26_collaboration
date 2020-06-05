package com.example.sopt_26_collaboration.network.response

import com.example.sopt_26_collaboration.recyclerview.FollowData

data class ResponseFollowData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<FollowData>
)