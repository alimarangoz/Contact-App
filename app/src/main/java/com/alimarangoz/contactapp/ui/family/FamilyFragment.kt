package com.alimarangoz.contactapp.ui.family

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.alimarangoz.contactapp.R
import com.alimarangoz.contactapp.databinding.FragmentFamilyBinding

class FamilyFragment : Fragment() {

    companion object {
        fun newInstance() = FamilyFragment()
    }

    private var _binding: FragmentFamilyBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: FamilyViewModel
    private lateinit var textFamily: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(FamilyViewModel::class.java)
        _binding = FragmentFamilyBinding.inflate(inflater,container, false)
        val view = binding.root
        textFamily = binding.textFamily
        viewModel.text.observe(viewLifecycleOwner){
            textFamily.text = it
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}