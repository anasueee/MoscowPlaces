package com.example.mosplaces.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mosplaces.Fragment3Adapter
import com.example.mosplaces.databinding.Fragment3Binding

class Fragment3 : Fragment() {
    private lateinit var binding: Fragment3Binding
    private lateinit var adapter: Fragment3Adapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = Fragment3Binding.inflate(layoutInflater)
        val root: View = binding.root

        val llm = LinearLayoutManager(context)
        adapter = Fragment3Adapter()
        adapter.data = adapter.getCards()
        binding.recyclerView.layoutManager = llm
        binding.recyclerView.adapter = adapter

        return root
    }
}