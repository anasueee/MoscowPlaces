package com.example.mosplaces.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.fragment.findNavController
import com.example.mosplaces.R
import com.google.android.material.switchmaterial.SwitchMaterial

class MainFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bF1 = view.findViewById<Button>(R.id.fragment1)
        val bF2 = view.findViewById<Button>(R.id.fragment2)
        val bF3 = view.findViewById<Button>(R.id.fragment3)
        val controller = findNavController()
        bF1.setOnClickListener{ controller.navigate(R.id.fragment1)}
        bF2.setOnClickListener{ controller.navigate(R.id.fragment2)}
        bF3.setOnClickListener{ controller.navigate(R.id.fragment3)}

        }
    }
