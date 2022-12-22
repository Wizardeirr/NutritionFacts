package com.volkankelleci.nutritionfacts.repository

import androidx.lifecycle.LiveData
import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact
import com.volkankelleci.nutritionfacts.retrofit.API
import com.volkankelleci.nutritionfacts.room.NutritionDao
import javax.inject.Inject

class NutritionRepository @Inject constructor(
    private val nutritionDao:NutritionDao,
    private val nutritionRetrofit:API
):NutritionRepositoryInterFace {
    override suspend fun insertNutrition(nutrition: IndividualNutritionFact) {
         nutritionDao.insertNutrition(nutrition)
    }

    override suspend fun deleteNutrition(nutrition: IndividualNutritionFact) {

        nutritionDao.deleteAll(nutrition)
    }

    override fun getNutrition(): LiveData<List<IndividualNutritionFact>> {
        return nutritionDao.observeArts()
    }

    override suspend fun nutritionSearch(searchQuery: String): List<IndividualNutritionFact> {
        return nutritionSearch(searchQuery)
    }
}