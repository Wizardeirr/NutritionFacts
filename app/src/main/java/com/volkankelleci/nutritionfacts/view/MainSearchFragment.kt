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
import androidx.navigation.fragment.findNavController
import com.volkankelleci.nutritionfacts.R
import com.volkankelleci.nutritionfacts.databinding.FragmentMainSearchBinding
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
        viewModel= ViewModelProvider(this)[NutritionViewModel::class.java]

        GET = this.requireActivity().getSharedPreferences("pref", MODE_PRIVATE)
        SET = GET.edit()

        var searchQuery = GET.getString("searchQuery", "")
        nutritionText.setText(searchQuery)
        viewModel.refreshData(searchQuery!!)
        subscribeToObserver()

        val binding= FragmentMainSearchBinding.bind(view)
        mainSearchFragmentBinding=binding


        analyzeButton.setOnClickListener {
            val nutritionNames = nutritionText.text.toString()
            SET.putString("cityName", searchQuery)
            SET.apply()
            viewModel.refreshData(nutritionNames)
            subscribeToObserver()
        }
    }
    fun subscribeToObserver(){
        viewModel.nutritions.observe(viewLifecycleOwner, Observer {
            it?.let {

            errorText.text=it.calories.toString()
                protein.text=it.cautions.toString()


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