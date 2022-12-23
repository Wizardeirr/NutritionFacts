package com.volkankelleci.nutritionfacts.retrofit

import com.volkankelleci.nutritionfacts.modeltwo.nutrition
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {


    private val BASE_URL="https://api.edamam.com/"
    private val api=retrofit2.
    Retrofit.
    Builder().
    baseUrl(BASE_URL).
    addConverterFactory(GsonConverterFactory.create()).
    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(NutritionAPI::class.java)
    fun getdata(nutritionName:String): Single<nutrition> {
        return api.getNutrition(nutritionName)

    }
}
