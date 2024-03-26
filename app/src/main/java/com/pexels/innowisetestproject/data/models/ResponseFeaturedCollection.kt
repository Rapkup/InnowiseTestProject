package com.pexels.innowisetestproject.data.models

import com.pexels.innowisetestproject.domain.models.FeaturedCollectionDomain

data class ResponseFeaturedCollection(
    val collections: List<FeaturedCollection>,
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val prev_page: String,
    val total_results: Int
)

data class FeaturedCollection(
    val description: String,
    val id: String,
    val media_count: Int,
    val photos_count: Int,
    val `private`: Boolean,
    val title: String,
    val videos_count: Int
)

fun List<FeaturedCollection>.mapToDomain(): List<FeaturedCollectionDomain> {
    return map {
        FeaturedCollectionDomain(
            id = it.id,
            title = it.title,
            description = it.description,
            private = it.private,
            media_count = it.media_count,
            photos_count = it.photos_count,
            videos_count = it.videos_count
        )
    }
}