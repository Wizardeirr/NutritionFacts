package com.volkankelleci.nutritionfacts.modelone

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity(tableName = "nutritiontable")

data class IndividualNutritionFact(
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

){
    @PrimaryKey(autoGenerate = true)
    val uuid:Int=0
}