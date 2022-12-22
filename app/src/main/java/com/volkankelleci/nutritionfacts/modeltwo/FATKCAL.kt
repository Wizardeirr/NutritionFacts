package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class FATKCAL(
    val label: String,
    val quantity: Int,
    val unit: String
)