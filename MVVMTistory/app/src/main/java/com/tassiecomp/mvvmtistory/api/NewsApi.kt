package com.tassiecomp.mvvmtistory.api

import com.tassiecomp.mvvmtistory.models.NewsResponse
import com.tassiecomp.mvvmtistory.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        //Suspend는 안에있는 함수들이 실행될때까지 다른 스레드를 멈추게 합니다.
        //다 불러오지 못했는데 다른 작업이 데이터를 요청하면 에러를 불러올수있기때문에 안전하게 데이터를 가져올수있습니다.
        @Query("country") //parameter를 넣어줍니다.
        countryCode:String = "us", //기본값으로 US를 넣어주었습니다.
        @Query("page")
        pageNumber:Int =1,
        @Query("apiKey")
        apiKey:String = API_KEY //편의를 위해 API_KEY를 constant 클래스에 모아서 관리하겠습니다.
    ):Response<NewsResponse>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q")
        searchQuery:String,
        @Query("page")
        pageNumber:Int =1,
        @Query("apiKey")
        apiKey:String = API_KEY //편의를 위해 API_KEY를 constant 클래스에 모아서 관리하겠습니다.
    ):Response<NewsResponse>
}