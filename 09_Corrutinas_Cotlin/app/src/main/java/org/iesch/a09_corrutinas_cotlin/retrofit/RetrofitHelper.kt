package org.iesch.a09_corrutinas_cotlin.retrofit

import org.iesch.a09_corrutinas_cotlin.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val URL = "https://www.superheroapi.com"
    private val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun getInstance(): ApiService{
        return retrofit.create(ApiService::class.java)
    }
}