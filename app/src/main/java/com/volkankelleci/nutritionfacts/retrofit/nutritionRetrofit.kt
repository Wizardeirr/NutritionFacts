package com.volkankelleci.nutritionfacts.retrofit

import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class nutritionRetrofit {
    //Base URL = https://api.edamam.com,

    private val BASE_URL="https://api.edamam.com,"
    private val api=Retrofit.Builder().
    baseUrl(BASE_URL).
    addConverterFactory(GsonConverterFactory.create()).
    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
    build().create(API::class.java)

    fun getData():Single<List<IndividualNutritionFact>> {
        return api.getNutrition()

    }
}