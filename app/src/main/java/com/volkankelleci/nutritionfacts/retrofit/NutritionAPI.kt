package com.volkankelleci.nutritionfacts.retrofit

import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NutritionAPI {
    //Base URL = https://api.edamam.com,
    // https://api.edamam.com/api/https://api.edamam.com/api/nutrition-data?app_id=a9a8f7ce&app_key=8baaf4365a5146edf16fe95080af67ad&nutrition-type=cooking&ingr=%22%22
    @GET("api.edamam.com/api/nutrition-data?app_id=a9a8f7ce&app_key=8baaf4365a5146edf16fe95080af67ad&nutrition-type=cooking&")

    fun getNutrition(@Query("ingr")searchQuery:String,):Single<IndividualNutritionFact>

}