package com.boyka.domain.usecase

import com.boyka.domain.repo.TimeRepo
import javax.inject.Inject

class GetNews @Inject constructor(
    private val apiHelper:TimeRepo
){

    suspend fun getData() = apiHelper.getNews()

}