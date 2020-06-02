package com.example.sopt_26_collaboration.data

data class ResponseContentData(
    val status : Int,
    val success : Boolean,
    val message : String,
    val data : List<ContentData>
)
data class ContentData(
    val contents_img : String,
    val contents_position : String,
    val contents_title : String,
    val contents_url : String
)