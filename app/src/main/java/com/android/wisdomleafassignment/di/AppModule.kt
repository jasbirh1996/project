package com.android.wisdomleafassignment.di

import com.android.wisdomleafassignment.data.remote.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): ApiInterface {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://picsum.photos/v2/")
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                        .apply {
                            level = HttpLoggingInterceptor.Level.NONE
                        }).build())
            .build()
            .create(ApiInterface::class.java)
    }

}