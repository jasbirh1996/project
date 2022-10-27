package com.android.wisdomleafassignment.data.remote

import com.android.wisdomleafassignment.data.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("list?")
    suspend fun getList(
        @Query("page") page: String,
        @Query("limit") limit: String
    ): Response<DataResponse>
}