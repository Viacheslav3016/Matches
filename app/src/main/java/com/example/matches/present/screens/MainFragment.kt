package com.example.matches.present.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.matches.databinding.FragmentMainBinding
import com.example.matches.present.adapters.FragmentMainAdapter
import com.example.matches.present.viewmodels.MainViewModel

class MainFragment : Fragment() {

    private lateinit var adapter: FragmentMainAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var rv_matches:RecyclerView

    private var _binding:FragmentMainBinding? = null
        get() = field ?:throw RuntimeException("FragmentMainBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        adapter = FragmentMainAdapter()
        rv_matches.adapter = adapter
        viewModel.loadMatch()
        viewModel._matches.observe(viewLifecycleOwner){
            adapter.setMatches(it)
        }

        viewModel._isLoad.observe(viewLifecycleOwner){
            if (it){
                binding.progressBarLoadMatch.visibility = (View.VISIBLE)
            }else{
                binding.progressBarLoadMatch.visibility = (View.GONE)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance():MainFragment {
            return MainFragment()
        }
    }
}