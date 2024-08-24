package com.example.why1.retropit

import com.google.gson.annotations.SerializedName

data class MainResonse(
    @SerializedName("consumption") val consumption: Int,
    @SerializedName("totalConsumptionPercent") val totalConsumptionPercent: Int,
    @SerializedName("highestCategory") val highestCategory: String,
    @SerializedName("additionalProp2") val additoanalProp2: Int,
)
