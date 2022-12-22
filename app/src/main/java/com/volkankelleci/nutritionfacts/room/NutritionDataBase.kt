package com.volkankelleci.nutritionfacts.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact

@Database(entities = [IndividualNutritionFact::class], version = 1)
abstract class NutritionDataBase:RoomDatabase() {
    abstract fun Dao():NutritionDao
}