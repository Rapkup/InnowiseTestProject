package com.pexels.innowisetestproject.data.repository

import android.util.Log
import com.pexels.innowisetestproject.data.api.ApiInterface
import com.pexels.innowisetestproject.data.models.mapToDomain
import com.pexels.innowisetestproject.domain.models.FeaturedCollectionDomain
import com.pexels.innowisetestproject.domain.models.PhotoDomain
import com.pexels.innowisetestproject.domain.repository.INetworkRepostory
import com.pexels.innowisetestproject.utilities.Constants.API_KEY

class NetworkRepository(private val apiService: ApiInterface) : INetworkRepostory {

    private suspend fun <T> executeRequest(
        request: suspend () -> T
    ): T? =
        try {
            request()
        } catch (exception: Exception) {
            null
        }


    override suspend fun getPhotoById(id: Int): PhotoDomain? =
        executeRequest {
            apiService.getPhotoById(API_KEY, id).mapToDomain()
        }


    override suspend fun getFeaturedCollection(
        page: Int,
        per_page: Int
    ): List<FeaturedCollectionDomain> =
        executeRequest {
            apiService.getFeaturedCollection(API_KEY, per_page, page)
                .collections.
                mapToDomain()
        } ?: emptyList()

    override suspend fun getCuratedCollection(
        page: Int,
        per_page: Int
    ): List<PhotoDomain> =
        executeRequest {
            apiService.getCuratedCollection(API_KEY, per_page, page)
                .photos
                .let { photos ->
                    photos.takeIf { it.isNotEmpty() }
                        ?.map { it.mapToDomain() }
                        ?: emptyList()
                }
        } ?: emptyList()

    override suspend fun getThematicCollection(
        query: String,
        page: Int,
        per_page: Int
    ): List<PhotoDomain> =
        executeRequest {
            apiService.getThematicCollection(API_KEY, query, per_page, page)
                .photos
                .let { photos ->
                    photos.takeIf { it.isNotEmpty() }
                        ?.map { it.mapToDomain() }
                        ?: emptyList()
                }
        } ?: emptyList()



}



