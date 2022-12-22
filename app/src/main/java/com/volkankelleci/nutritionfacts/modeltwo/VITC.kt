package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class VITC(
    val label: String,
    val quantity: Double,
    val unit: String
)