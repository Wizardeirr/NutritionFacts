package com.volkankelleci.nutritionfacts.view

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.volkankelleci.nutritionfacts.R
import com.volkankelleci.nutritionfacts.databinding.FragmentMainSearchBinding
import com.volkankelleci.nutritionfacts.modeltwo.nutrition
import com.volkankelleci.nutritionfacts.viewmodel.NutritionViewModel
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_main_search.*
import retrofit2.http.GET

class MainSearchFragment : Fragment() {

    private lateinit var viewModel:NutritionViewModel
    private var mainSearchFragmentBinding:FragmentMainSearchBinding?=null
    private lateinit var GET: SharedPreferences
    private lateinit var SET: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GET = requireActivity().getSharedPreferences("com.volkankelleci.nutritionfacts.view",
            MODE_PRIVATE)
            //getSharedPreferences(packageName, MODE_PRIVATE)
        SET = GET.edit()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_search, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProviders.of(this).get(NutritionViewModel::class.java)
        var nutritionInput = GET.getString("cityName", "malatya")

        nutritionText.setText(nutritionInput)
        viewModel.refreshData(nutritionInput!!)

        subscribeToObserver()
        analyzeButton.setOnClickListener {
            val nutritionNames = nutritionText.text.toString()
            SET.putString("cityName", nutritionNames)
            SET.apply()
            viewModel.refreshData(nutritionNames)
            subscribeToObserver()
        }

    }
    fun subscribeToObserver(){
        viewModel.nutritions.observe(viewLifecycleOwner, Observer {
            it?.let {
            textView4.text=it.get(0).calories.toString()


            }
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            if(it) {
                errorText.visibility=View.VISIBLE
                progressBar.visibility=View.GONE

            }else{
                errorText.visibility=View.GONE
            }
        })
        viewModel.progressBar.observe(viewLifecycleOwner, Observer {
            if(it) {
                errorText.visibility=View.GONE
                progressBar.visibility=View.VISIBLE

            }else{
                progressBar.visibility=View.GONE
            }
        })
    }

}