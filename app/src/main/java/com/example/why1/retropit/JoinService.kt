package com.example.why1.retropit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface JoinService {
    @POST("api/v1/user/signup")
    fun Register(@Body credential: JoinRequest) : Call<JoinResponse>
}