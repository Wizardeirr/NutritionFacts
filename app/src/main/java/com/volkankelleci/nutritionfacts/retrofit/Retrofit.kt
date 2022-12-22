package com.volkankelleci.nutritionfacts.retrofit

import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact
import io.reactivex.Single
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    // BASE URL = https://raw.githubusercontent.com/atilsamancioglu/BTK20-JSONVeriSeti/master/besinler.json
    private val BASE_URL="https://api.edamam.com/"
    private val api=retrofit2.Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Retrofit::class.java)


    fun getdata(): Single<IndividualNutritionFact> {
        return api.getdata()

    }
}
