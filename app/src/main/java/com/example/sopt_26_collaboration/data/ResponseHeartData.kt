package com.example.sopt_26_collaboration.data

data class ResponseHeartData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<HeartData>
)
data class HeartData(
    val company_name : String,
    val company_hearts : Int
)