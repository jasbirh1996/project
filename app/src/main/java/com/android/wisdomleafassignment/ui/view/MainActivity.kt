package com.android.wisdomleafassignment.ui.view

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.android.wisdomleafassignment.R
import com.android.wisdomleafassignment.databinding.ActivityMainBinding
import com.android.wisdomleafassignment.ui.DataAdapter
import com.android.wisdomleafassignment.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    // root  view
    // one Activity multiple fragment mvvm project
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // navigating to splash
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer,SplashFragment()).commit()


    }

companion object{
    // for refreshing
    fun refresh(fragmentManager : FragmentManager) {
     fragmentManager.beginTransaction().replace(R.id.mainContainer,MainFragment()).commit()
    }
}


}