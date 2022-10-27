package com.android.wisdomleafassignment.ui.view

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.android.wisdomleafassignment.R
import com.android.wisdomleafassignment.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashFragment : Fragment() {

    private lateinit var binding : FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSplashBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
// to delay 5 sec we are using coroutines scope
        lifecycleScope.launch {
            delay(5000)
            // navigating to main view
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,MainFragment()).commit()
        }
    }





}

