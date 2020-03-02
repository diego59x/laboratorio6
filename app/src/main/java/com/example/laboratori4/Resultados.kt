package com.example.laboratori4

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup





class Resultados : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultados, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //view.findViewById<TextView>(R.id.textView).text = recipient
        //super.onViewCreated(view, savedInstanceState)
        //navController = Navigation.findNavController(view)
        (activity as MainActivity).supportActionBar?.title = "Respuestas"
    }







}
