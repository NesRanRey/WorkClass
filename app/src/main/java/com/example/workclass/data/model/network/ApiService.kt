package com.example.workclass.data.model.network

import com.example.workclass.data.model.UserModel
import com.example.workclass.data.model.viewmodel.AccountModel
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("user")
    suspend fun login (@Body user: UserModel): Response<JsonObject>

    @GET("service")
    suspend fun getAccounts():Response<List<AccountModel>>

}