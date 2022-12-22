package com.volkankelleci.nutritionfacts.repository

import androidx.lifecycle.LiveData
import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact

interface NutritionRepositoryInterFace {
    suspend fun insertNutrition(nutrition:IndividualNutritionFact)
    suspend fun deleteNutrition(nutrition:IndividualNutritionFact)
    fun getNutrition(): LiveData<List<IndividualNutritionFact>>
    suspend fun nutritionSearch(searchQuery:String):List<IndividualNutritionFact>
}