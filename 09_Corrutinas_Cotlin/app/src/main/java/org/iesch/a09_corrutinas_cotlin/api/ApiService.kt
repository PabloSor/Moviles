package org.iesch.a09_corrutinas_cotlin.api

import com.google.gson.annotations.SerializedName
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/10229233666327556/search/{name}")
    fun getSuperHeroes(@Path("name") superHeroName: String) : Response<SuperHeroDataResponse>
}

data class SuperHeroDataResponse (
    @SerializedName("response") val response: String
)
