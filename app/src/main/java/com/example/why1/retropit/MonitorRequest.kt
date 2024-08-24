package com.example.why1.retropit

import com.google.gson.annotations.SerializedName

data class MonitorRequest(
    @SerializedName("userId") val userId: Int,
    @SerializedName("date") val date: String
)
