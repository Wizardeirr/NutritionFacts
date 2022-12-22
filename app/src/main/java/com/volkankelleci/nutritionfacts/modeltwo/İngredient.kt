package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class İngredient(
    val parsed: List<Parsed>,
    val text: String
)