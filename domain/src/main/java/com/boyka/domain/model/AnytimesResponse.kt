package com.boyka.domain.model

data class AnytimesResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)