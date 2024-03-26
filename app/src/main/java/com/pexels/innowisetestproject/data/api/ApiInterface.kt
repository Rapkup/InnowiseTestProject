package com.pexels.innowisetestproject.data.api;
import com.pexels.innowisetestproject.data.models.ResponseFeaturedCollection
import com.pexels.innowisetestproject.data.models.ImageResponce
import com.pexels.innowisetestproject.data.models.Photo;


import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query

interface ApiInterface {

    /*GetThematicCollection (search)
      GetCuratedCollection (auto load)
      GetFeaturedCollection (featured)
      GetImageById*/


    @GET("photos/{id}")
    suspend fun getPhotoById(
            @Header("Authorization") apiKey: String,
            @Path("id") id: Int
    ): Photo

    @GET("search")
    suspend fun getThematicCollection(
        @Header("Authorization") apiKey: String,
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ) : ImageResponce

    @GET("curated")
    suspend fun getCuratedCollection(
        @Header("Authorization") apiKey: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ) : ImageResponce

    @GET("collections/featured")
    suspend fun getFeaturedCollection(
        @Header("Authorization") apiKey: String,
        @Query("per_page") perPage: Int,
        @Query("page") page : Int = 1
    ): ResponseFeaturedCollection











}
