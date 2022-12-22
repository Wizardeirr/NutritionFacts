package com.volkankelleci.nutritionfacts.modelone

import javax.inject.Inject


data class IndividualNutritionFact(
    @Inject
    val calories: Int,
    val cautions: List<Any>,
    val dietLabels: List<Any>,
    val healthLabels: List<String>,
    val ingredients: List<İngredient>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalNutrientsKCal: TotalNutrientsKCal,
    val totalWeight: Double,
    val uri: String
)