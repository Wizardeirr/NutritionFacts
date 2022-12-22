package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class P(
    val label: String,
    val quantity: Double,
    val unit: String
)