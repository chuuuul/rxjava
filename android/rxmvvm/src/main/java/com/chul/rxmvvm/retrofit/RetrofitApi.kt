package com.chul.rxmvvm.retrofit

import com.chul.rxmvvm.model.NaverMovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitApi {

    @GET("v1/search/movie.json")
    @Headers(
        "X-Naver-Client-Id: y5_NNkPCE9ItVzDN4SYN",
        "X-Naver-Client-Secret: dVE5yklLXs"
    )
    fun getMovieList(@Query("query") query: String): Single<NaverMovieResponse>


}