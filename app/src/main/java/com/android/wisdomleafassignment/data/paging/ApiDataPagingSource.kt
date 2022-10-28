package com.android.wisdomleafassignment.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState

import com.android.wisdomleafassignment.data.model.DataResponseItem
import com.android.wisdomleafassignment.data.remote.ApiInterface

import javax.inject.Inject

class ApiDataPagingSource @Inject
constructor(private val apiInterface: ApiInterface) :
    PagingSource<Int, DataResponseItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataResponseItem> {
        val currentPageKey = params.key ?: 0
        val limit = 20
        return try {


            val response = apiInterface.getList(currentPageKey.toString(),limit.toString()).body()
            val mList = response
            LoadResult.Page(
                data = mList!!,
                prevKey = if (currentPageKey == 0) null else currentPageKey - 1,
                nextKey = if (mList.isNullOrEmpty()) null else currentPageKey + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataResponseItem>): Int? {

        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    }





}