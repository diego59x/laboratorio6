package com.example.laboratori4


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.example.laboratori4.databinding.FragmentBiografiaBinding
import kotlinx.android.synthetic.main.fragment_biografia.*
import kotlinx.android.synthetic.main.fragment_main.*


class Biografia : Fragment(), View.OnClickListener {
    lateinit var binding: FragmentBiografiaBinding
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_biografia, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as MainActivity).supportActionBar?.title = "Biografia"
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.ok -> {
                navController!!.navigate(R.id.action_biografia2_to_mainFragment)
            }
        }
    }
}



