package com.volkankelleci.nutritionfacts.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.volkankelleci.nutritionfacts.R
import com.volkankelleci.nutritionfacts.util.Util.BASE_URL
import com.volkankelleci.nutritionfacts.repository.NutritionRepository
import com.volkankelleci.nutritionfacts.repository.NutritionRepositoryInterFace
import com.volkankelleci.nutritionfacts.retrofit.API
import com.volkankelleci.nutritionfacts.room.NutritionDao
import com.volkankelleci.nutritionfacts.room.NutritionDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun injectRoomDataBase(@ApplicationContext context:Context) =

    Room.databaseBuilder(context,NutritionDataBase::class.java,"nutritionDB").build()
    @Singleton
    @Provides
    fun injectDao(dataBase: NutritionDataBase)=dataBase.Dao()
    @Singleton
    @Provides
    fun injectRetrofitAPI(): API {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(API::class.java)
    }
    @Singleton
    @Provides
    fun injectNormalRepo(dao:NutritionDao,api:API)=NutritionRepository(dao,api) as NutritionRepositoryInterFace

    @Singleton
    @Provides
    fun injectGlide(@ApplicationContext context: Context)= Glide.with(context)
        .setDefaultRequestOptions(
            RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
        )

}