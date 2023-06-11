package com.boyka.mylibrary.repo

import com.boyka.domain.model.AnytimesResponse
import com.boyka.domain.repo.TimeRepo
import com.boyka.mylibrary.R
import com.boyka.mylibrary.remote.ApiService
import com.boyka.mylibrary.utils.Const
import retrofit2.Response
import javax.inject.Inject

class TimeRepoImpl@Inject constructor(
    private val apiService: ApiService
): TimeRepo {

    override suspend fun getNews(): Response<AnytimesResponse> = apiService.getNew(Const.Key)

}