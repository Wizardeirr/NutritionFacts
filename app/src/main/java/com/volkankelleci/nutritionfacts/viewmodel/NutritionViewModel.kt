package com.volkankelleci.nutritionfacts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.volkankelleci.nutritionfacts.modelone.IndividualNutritionFact
import com.volkankelleci.nutritionfacts.retrofit.Retrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


class NutritionViewModel():ViewModel() {

    val nutritions=MutableLiveData<IndividualNutritionFact>()
    val errorMessage=MutableLiveData<Boolean>()
    val progressBar=MutableLiveData<Boolean>()

    private val nutritionAPIService=Retrofit()
    private val disposable= CompositeDisposable()
    fun refreshData(){
        takesToDataFromInternet()
    }
    private fun takesToDataFromInternet(){

        disposable.add(
            nutritionAPIService.getdata()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<IndividualNutritionFact>() {
                    override fun onSuccess(t: IndividualNutritionFact) {
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