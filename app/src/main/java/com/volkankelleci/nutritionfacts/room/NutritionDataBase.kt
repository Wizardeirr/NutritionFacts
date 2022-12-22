package com.volkankelleci.nutritionfacts.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact


abstract class NutritionDataBase:RoomDatabase() {
    abstract fun Dao():NutritionDao
}