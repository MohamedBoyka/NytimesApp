package com.boyka.domain.model

data class Media(
    val approved_for_syndication: Int,
    val caption: String,
    val copyright: String,
    val mediaMetadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
)