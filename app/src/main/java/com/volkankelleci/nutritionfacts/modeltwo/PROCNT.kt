package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class PROCNT(
    val label: String,
    val quantity: Double,
    val unit: String
)