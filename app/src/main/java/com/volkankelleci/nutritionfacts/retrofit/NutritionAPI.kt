package com.volkankelleci.nutritionfacts.retrofit


import com.volkankelleci.nutritionfacts.modeltwo.nutrition
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface NutritionAPI {
    //Base URL = https://api.edamam.com,
    // https://api.edamam.com/api/nutrition-data?app_id=a9a8f7ce&app_key=8baaf4365a5146edf16fe95080af67ad&nutrition-type=cooking&ingr=%22%22
    @GET("nutrition-data?app_id=a9a8f7ce&app_key=8baaf4365a5146edf16fe95080af67ad&nutrition-type=logging&=apple")
//https://api.edamam.com/api/n

    fun getNutrition(@Query("ingr") nutritionName:String):Single<nutrition>

}