package com.example.nav.api

import com.example.nav.model.Products
import retrofit2.http.GET

interface  ApiInterface{
    @GET("products")
    suspend fun  getProductList():List<Products>
}
