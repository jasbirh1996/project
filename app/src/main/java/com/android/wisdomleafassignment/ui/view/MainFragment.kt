package com.android.wisdomleafassignment.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.android.wisdomleafassignment.R
import com.android.wisdomleafassignment.data.model.DataResponseItem
import com.android.wisdomleafassignment.databinding.FragmentMainBinding
import com.android.wisdomleafassignment.ui.DataAdapter
import com.android.wisdomleafassignment.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainFragment : Fragment() {
    private  lateinit var binding : FragmentMainBinding
    val viewModel : MainViewModel by viewModels()
    private lateinit var adapter : DataAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEssentials()
        setRecyclerView()
        fetchApiData()
        binding.refresh.setOnClickListener {
            MainActivity.refresh(requireActivity().supportFragmentManager)


        }
    }

    private fun fetchApiData() {
        lifecycleScope.launch {
            viewModel.fetchApiLiveData().collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun setRecyclerView() {
        binding.rvData.layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvData.adapter = adapter
    }

    private fun initEssentials(){
        adapter = DataAdapter(object :DataAdapter.OnItemTap{
            override fun itemTapped(data: DataResponseItem) {
                Toast.makeText(requireContext(),data.author.toString(),Toast.LENGTH_LONG).show()

            }

        })
    }




}