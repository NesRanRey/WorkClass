package com.example.workclass.data.model.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.workclass.data.model.network.RetrofitClient
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val api= RetrofitClient.api

    fun loginAPI(user_model: UserModel, onResult: (JsonObject?)-> Unit){
        viewModelScope.launch {
            try {
                val response = api.login(user_model)
                if (response.isSuccessful){
                    val jsonResponse = response.body()
                    Log.d("debug", "${response.body()}")
                    onResult(jsonResponse)

                }else{
                        Log.d("debug","ERROR: ${response.errorBody()}")
                    onResult(null)
                }
            }catch (exception: Exception){
                Log.d("debug","API CALL FAILED $exception")
                onResult(null)
            }
        }
    }
}