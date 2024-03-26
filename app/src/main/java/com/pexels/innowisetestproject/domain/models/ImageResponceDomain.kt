package com.pexels.innowisetestproject.domain.models

data class ImageResponceDomain(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: List<PhotoDomain>
)