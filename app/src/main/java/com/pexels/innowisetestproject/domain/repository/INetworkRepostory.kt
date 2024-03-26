package com.pexels.innowisetestproject.domain.repository

import com.pexels.innowisetestproject.domain.models.FeaturedCollectionDomain
import com.pexels.innowisetestproject.domain.models.ResponseFeaturerdCollectionDomain
import com.pexels.innowisetestproject.domain.models.PhotoDomain

interface INetworkRepostory {

    suspend fun getFeaturedCollection(
        page: Int,
        per_page: Int
    ): List<FeaturedCollectionDomain>


    suspend fun getThematicCollection(
        query: String,
        page: Int,
        per_page: Int
    ): List<PhotoDomain>

    suspend fun getCuratedCollection(
        page: Int,
        per_page: Int
    ): List<PhotoDomain>

    suspend fun getPhotoById(
        id: Int
    ): PhotoDomain?
}