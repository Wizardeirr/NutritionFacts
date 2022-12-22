package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class MG(
    val label: String,
    val quantity: Double,
    val unit: String
)