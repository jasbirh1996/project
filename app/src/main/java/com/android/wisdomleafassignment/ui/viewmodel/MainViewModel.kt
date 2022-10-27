package com.android.wisdomleafassignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.android.wisdomleafassignment.data.model.DataResponseItem
import com.android.wisdomleafassignment.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class MainViewModel
@Inject constructor(private val marvelRepositoryImpl: MainRepository): ViewModel(){

    fun fetchApiLiveData(): Flow<PagingData<DataResponseItem>> {
        return marvelRepositoryImpl.getApiDataItem()
            .cachedIn(viewModelScope)
    }
}