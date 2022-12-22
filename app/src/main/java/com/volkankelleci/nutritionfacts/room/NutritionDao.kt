package com.volkankelleci.nutritionfacts.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact

@Dao
interface NutritionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNutrition(nutrition:IndividualNutritionFact)
    @Delete
    suspend fun deleteAll(nutrition: IndividualNutritionFact)
    @Query("SELECT*FROM nutritiontable")
    fun observeArts(): LiveData<List<IndividualNutritionFact>>
}