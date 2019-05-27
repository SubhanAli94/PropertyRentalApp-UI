package com.crazybani.property.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager{
    private val BASE_URL = "";
    private var retrofit: Retrofit? = null

    private fun initRetrofitInstance() {
        if (retrofit == null) {

            var interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            var client = OkHttpClient.Builder()
            client.addInterceptor(interceptor)

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client.build())
                .build()

        }
    }
}