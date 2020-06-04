package com.example.sopt_26_collaboration.network.response

import com.example.sopt_26_collaboration.recyclerview.CompanyData

data class CompanyResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<CompanyData>
)