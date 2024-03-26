package com.pexels.innowisetestproject.domain.models

import androidx.navigation.NavType
import java.io.Serializable

data class PhotoDomain(
    val alt: String,
    val avg_color: String,
    val height: Int,
    val id: Int,
    val liked: Boolean,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    val src: SrcDomain,
    val url: String,
    val width: Int
) : Serializable

data class SrcDomain(
    val landscape: String,
    val large: String,
    val large2x: String,
    val medium: String,
    val original: String,
    val portrait: String,
    val small: String,
    val tiny: String
)