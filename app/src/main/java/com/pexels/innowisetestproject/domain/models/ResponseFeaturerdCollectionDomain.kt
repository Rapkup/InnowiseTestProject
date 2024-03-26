package com.pexels.innowisetestproject.domain.models

data class ResponseFeaturerdCollectionDomain(
    val collections: List<FeaturedCollectionDomain>,
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val prev_page: String,
    val total_results: Int
)


data class FeaturedCollectionDomain(
    val description: String,
    val id: String,
    val media_count: Int,
    val photos_count: Int,
    val `private`: Boolean,
    val title: String,
    val videos_count: Int
)