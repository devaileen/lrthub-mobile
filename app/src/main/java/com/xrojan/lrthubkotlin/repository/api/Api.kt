package com.xrojan.lrthubkotlin.repository.api

import com.xrojan.lrthubkotlin.credentials.Credentials.Companion.apiKey
import com.xrojan.lrthubkotlin.repository.entities.*
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by Joshua de Guzman on 10/07/2018.
 */

interface UserApi {
    @FormUrlEncoded
    @POST("/api/v1/token/generate")
    fun loginUser(@Field("username") username: String,
                  @Field("password") password: String): Observable<Request<User>>

    @FormUrlEncoded
    @POST("/api/v1/users/create/")
    fun registerUser(@Field("username") username: String,
                     @Field("password") password: String,
                     @Field("email") email: String): Observable<Request<User>>

    @GET("/api/v1/users/profile/")
    fun getUserDetail(
            @Header("Api-Key") apiKey: String,
            @Header("Authorization") token: String,
            @Query("user_id") userId: Int): Observable<RequestArray<List<UserProfile>>>
}

interface FeedApi {
    @GET("/api/v1/feeds/all/")
    fun getFeeds(
            @Header("Api-Key") apiKey: String,
            @Query("search") search: String): Observable<RequestArray<List<Feed>>>

    @GET("/api/v1/feeds/")
    fun getFeeds(
            @Header("Api-Key") apiKey: String,
            @Query("is_featured") isFeatured: Boolean): Observable<RequestArray<List<Feed>>>
}

interface ChatbotApi {
    @POST("https://lrthub.azurewebsites.net/qnamaker/knowledgebases/43941e99-7626-464a-997d-e49e2b598eb3/generateAnswer")
    fun queryChatbot(@Header("Authorization") authorization: String,
                     @Header("Content-Type") contentType: String,
                     @Body question: Question): Observable<Answers>
}