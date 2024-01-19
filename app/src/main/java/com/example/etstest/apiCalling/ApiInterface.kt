package com.example.etstest.apiCalling

import com.example.etstest.modelClass.BottomPojo
import com.example.etstest.modelClass.MiddlePojo
import com.example.etstest.pojo.CategoryPojo
import com.example.etstest.pojo.TopPojo
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


    @GET("top_repository.json")
    fun getTopResults(): Call<TopPojo>

    @GET("middle_repository.json")
    fun getMiddleResults(): Call<MiddlePojo>

    @GET("bottom_repository.json")
    fun getBottomResults(): Call<BottomPojo>

    @GET("category_repository.json")
    fun getCategoryResults(): Call<CategoryPojo>


//    @GET("?")
//    fun getResponceForIgPublicReels(@Query("query_hash") queryHash:String, @Query("variables") variables: String ): Call<IgPublicReelsJsonResponce>
//
//    @GET("?")
//    fun getResponceForIgPublicPost(@Query("query_hash") queryHash:String, @Query("variables") variables: String ): Call<IgPublicPostJsonResponce>
//
//
}