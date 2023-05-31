package com.alimarangoz.contactapp.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alimarangoz.contactapp.adapters.ContactAdapter
import com.alimarangoz.contactapp.databinding.FragmentSlideshowBinding

class WorkFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null


    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = binding.recyclerView
        val adapter = ContactAdapter()

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        val workViewModel = ViewModelProvider(this)[WorkViewModel::class.java]

        workViewModel.getAllContacts().observe(viewLifecycleOwner) { contacts ->
            adapter.submitList(contacts)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}