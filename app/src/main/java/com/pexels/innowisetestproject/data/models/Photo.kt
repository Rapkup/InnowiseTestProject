package com.pexels.innowisetestproject.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pexels.innowisetestproject.domain.models.PhotoDomain
import com.pexels.innowisetestproject.domain.models.SrcDomain
import java.io.Serializable


@Entity("Favourite_photos")
data class Photo(
    @PrimaryKey
    val id: Int,
    val alt: String,
    val avg_color: String,
    val height: Int,
    val liked: Boolean,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    @Embedded(prefix = "Src_")
    val src: Src,
    val url: String,
    val width: Int
) : Serializable


data class Src(
    val landscape: String,
    val large: String,
    val large2x: String,
    val medium: String,
    val original: String,
    val portrait: String,
    val small: String,
    val tiny: String
)

fun Photo.mapToDomain(): PhotoDomain{
    return PhotoDomain(
        alt = this.alt,
        avg_color = this.avg_color,
        height =  this.height,
        id =  this.id,
        liked =  this.liked,
        photographer =  this.photographer,
        photographer_id =  this.photographer_id,
        photographer_url =  this.photographer_url,
        src = SrcDomain(
            landscape = this.src.landscape,
            large = this.src.large,
            large2x = this.src.large2x,
            medium =  this.src.medium,
            original = this.src.original,
            portrait = this.src.portrait,
            small = this.src.small,
            tiny =  this.src.tiny
        ),
        url =  this.url,
        width =  this.width
    )
}

fun PhotoDomain.mapToPhoto(): Photo{
    return Photo(
        alt = this.alt,
        avg_color = this.avg_color,
        height =  this.height,
        id =  this.id,
        liked =  this.liked,
        photographer =  this.photographer,
        photographer_id =  this.photographer_id,
        photographer_url =  this.photographer_url,
        src = Src(
            landscape = this.src.landscape,
            large = this.src.large,
            large2x = this.src.large2x,
            medium =  this.src.medium,
            original = this.src.original,
            portrait = this.src.portrait,
            small = this.src.small,
            tiny =  this.src.tiny
        ),
        url =  this.url,
        width =  this.width
    )
}