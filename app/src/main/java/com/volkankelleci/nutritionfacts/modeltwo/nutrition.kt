package com.volkankelleci.nutritionfacts.modeltwo


import com.google.gson.annotations.SerializedName

data class nutrition(
    val calories: Int,
    val cautions: List<String>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val ingredients: List<İngredient>,
    val totalNutrientsKCal: TotalNutrientsKCal,
    val totalWeight: Double,
    val uri: String
)