package com.boyka.mylibrary.remote

import com.boyka.domain.model.AnytimesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("svc/mostpopular/v2/viewed/1.json")
    suspend fun getNew(@Query("api-key") key :String): Response<AnytimesResponse>


}