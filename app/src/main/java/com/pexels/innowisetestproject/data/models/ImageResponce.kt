package com.pexels.innowisetestproject.data.models

data class ImageResponce(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: List<Photo>
)