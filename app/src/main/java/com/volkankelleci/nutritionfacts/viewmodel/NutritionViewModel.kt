package com.volkankelleci.nutritionfacts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.nutritionfacts.modeltwo.nutrition

import com.volkankelleci.nutritionfacts.retrofit.Retrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.http.Query


class NutritionViewModel():ViewModel() {

    val nutritions=MutableLiveData<nutrition>()
    val errorMessage=MutableLiveData<Boolean>()
    val progressBar=MutableLiveData<Boolean>()

    private val nutritionAPIService=Retrofit()
    private val disposable= CompositeDisposable()
    fun refreshData(nutritionName: String){
        takesToDataFromInternet(nutritionName)
    }
    private fun takesToDataFromInternet(nutritionName:String){

        disposable.add(
            nutritionAPIService.getdata(nutritionName)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<nutrition>() {
                    override fun onSuccess(t: nutrition) {
                        nutritions.value=t
                        errorMessage.value=false
                        progressBar.value=false
                    }
                    override fun onError(e: Throwable) {
                        errorMessage.value=true
                        progressBar.value=false
                        e.printStackTrace()
                    }
                })
        )
    }
}