package com.example.sopt_26_collaboration.data

data class ResponseRecruitData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<RecruitData>
)
data class RecruitData(
    val company_img : String,
    val company_name : String,
    val company_location : String,
    val recruit_position : String,
    var company_hearts : Int,
    val company_idx : Int
)