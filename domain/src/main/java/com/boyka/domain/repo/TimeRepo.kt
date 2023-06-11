package com.boyka.domain.repo

import com.boyka.domain.model.AnytimesResponse
import retrofit2.Response

interface TimeRepo {

    suspend fun getNews(): Response<AnytimesResponse>
}