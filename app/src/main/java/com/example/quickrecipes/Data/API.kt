package com.example.quickrecipes.Data

import com.example.quickrecipes.CategoriesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipe = retrofit.create(API::class.java)

interface API {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

}