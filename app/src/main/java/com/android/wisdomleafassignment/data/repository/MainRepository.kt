package com.android.wisdomleafassignment.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.android.wisdomleafassignment.data.model.DataResponseItem
import com.android.wisdomleafassignment.data.paging.ApiDataPagingSource
import com.android.wisdomleafassignment.utils.AppConstant.DEFAULT_PAGE_SIZE_CHARACTER
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(val pagingSource: ApiDataPagingSource) {

    fun getApiDataItem(pagingConfig: PagingConfig = getDefaultPageConfig()): Flow<PagingData<DataResponseItem>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { pagingSource }
        ).flow
    }


    fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = DEFAULT_PAGE_SIZE_CHARACTER, enablePlaceholders = false)
    }
}