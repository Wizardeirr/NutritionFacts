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
        viewModel= ViewModelProvider(this)[NutritionViewModel::class.java]
        viewModel.refreshData()

        return inflater.inflate(R.layout.fragment_main_search, container, false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val GET = this.requireActivity()
            .getSharedPreferences("pref", MODE_PRIVATE)
        SET = GET.edit()
        var nutritionInput = GET.getString("cityName", "malatya")
        nutritionText.setText(nutritionInput)
        viewModel.refreshData()
        subscribeToObserver()
        val binding=FragmentMainSearchBinding.bind(view)
        mainSearchFragmentBinding=binding

        analyzeButton.setOnClickListener {
            val action=MainSearchFragmentDirections.actionMainSearchFragmentToDetailFragment()
            findNavController().navigate(action)

        }
        analyzeButton.setOnClickListener {
            val cityName = nutritionText.text.toString()
            SET.putString("cityName", cityName)
            SET.apply()
            viewModel.refreshData()
            subscribeToObserver()
        }
    }
    fun subscribeToObserver(){
        viewModel.nutritions.observe(viewLifecycleOwner, Observer {
            it?.let {
    


            }
        })
    }
}