package com.example.why1.retropit

import com.google.gson.annotations.SerializedName

data class SmonitorRsponse(
    @SerializedName("totalConsumption") val totalConsumption: Int,
    @SerializedName("percentageOfBudget") val percentageOfBudget: Int,
    @SerializedName("lastConsumption") val lastConsumption: Boolean,
    @SerializedName("gptAdvice") val gptAdvice: String,
    @SerializedName("highestCategory") val highestCategory: String,
    @SerializedName("highestCategoryPercent") val highestCategoryPercent: Int,
    @SerializedName("lowestCategory") val lowestCategory: String,
    @SerializedName("lowestCategoryPercent") val lowestCategoryPercent: Int,
)
