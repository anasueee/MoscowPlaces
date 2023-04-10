package com.example.mosplaces.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mosplaces.Fragment2Adapter
import com.example.mosplaces.Fragment3Adapter
import com.example.mosplaces.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private lateinit var binding: Fragment2Binding
    private lateinit var adapter: Fragment2Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment2Binding.inflate(layoutInflater)
        val root: View = binding.root

        val llm = LinearLayoutManager(context)
        adapter = Fragment2Adapter()
        adapter.data = adapter.getCards()
        binding.recyclerView.layoutManager = llm
        binding.recyclerView.adapter = adapter

        return root
    }
}