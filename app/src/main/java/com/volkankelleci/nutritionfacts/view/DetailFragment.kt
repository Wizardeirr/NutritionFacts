package com.volkankelleci.nutritionfacts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.volkankelleci.nutritionfacts.R
import com.volkankelleci.nutritionfacts.viewmodel.NutritionViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {
    private lateinit var viewModel: NutritionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kcal.setOnClickListener {
            val action=DetailFragmentDirections.actionDetailFragmentToKcalFragment()
            findNavController().navigate(action)
        }
    }
    fun subscribeToObserver(){
        viewModel.nutritions.observe(viewLifecycleOwner, Observer {
            it?.let {

            }
        })
    }
}