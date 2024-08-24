package com.example.why1.retropit

import com.google.gson.annotations.SerializedName

data class DmonitorResponse(
    @SerializedName("highestCategory") val highestCategory: String,
    @SerializedName("highestCategoryPercent") val highestCategoryPercent: Int,
    @SerializedName("lowestCategory") val lowestCategory: String,
    @SerializedName("lowestCategoryPercent") val lowestCategoryPercent: Int,
    @SerializedName("entertainmentCategoryChangePercent") val entertainmentCategoryChangePercent: Int, //오락비
    @SerializedName("entertainmentCategoryChangeBudget") val entertainmentCategoryChangeBudget: Int,
    @SerializedName("entertainmentCategoryChangeUsePercent") val entertainmentCategoryChangeUsePercent: Int,
    @SerializedName("cultureCategoryChangePercent") val cultureCategoryChangePercent: Int, //문화비
    @SerializedName("cultureCategoryChangeBudget") val cultureCategoryChangeBudget: Int,
    @SerializedName("cultureCategoryChangeUsePercent") val cultureCategoryChangeUsePercent: Int,
    @SerializedName("cafeCategoryChangePercent") val cafeCategoryChangePercent: Int, //카페
    @SerializedName("cafeCategoryChangeBudget") val cafeCategoryChangeBudget: Int,
    @SerializedName("cafeCategoryChangeUsePercent") val cafeCategoryChangeUsePercent: Int,
    @SerializedName("sportsCategoryChangePercent") val sportsCategoryChangePercent: Int, //스포츠
    @SerializedName("sportsCategoryChangeBudget") val sportsCategoryChangeBudget: Int,
    @SerializedName("sportsCategoryChangeUsePercent") val sportsCategoryChangeUsePercent: Int,
    @SerializedName("foodCategoryChangePercent") val foodCategoryChangePercent: Int, //음식점
    @SerializedName("foodCategoryChangeBudget") val foodCategoryChangeBudget: Int,
    @SerializedName("foodCategoryChangeUsePercent") val foodCategoryChangeUsePercent: Int,
    @SerializedName("accommodationCategoryChangePercent") val accommodationCategoryChangePercent: Int, //숙박비
    @SerializedName("accommodationCategoryChangeBudget") val accommodationCategoryChangeBudget: Int,
    @SerializedName("accommodationCategoryChangeUsePercent") val accommodationCategoryChangeUsePercent: Int,
    @SerializedName("retailCategoryChangePercent") val retailCategoryChangePercent: Int,  //잡화소매
    @SerializedName("retailCategoryChangeBudget") val retailCategoryChangeBudget: Int,
    @SerializedName("retailCategoryChangeUsePercent") val retailCategoryChangeUsePercent: Int,
    @SerializedName("shoppingCategoryChangePercent") val shoppingCategoryChangePercent: Int, //쇼핑
    @SerializedName("shoppingCategoryChangeBudget") val shoppingCategoryChangeBudget: Int,
    @SerializedName("shoppingCategoryChangeUsePercent") val shoppingCategoryChangeUsePercent: Int,
    @SerializedName("transferCategoryChangePercent") val transferCategoryChangePercent: Int, //개인이체
    @SerializedName("transferCategoryChangeBudget") val transferCategoryChangeBudget: Int,
    @SerializedName("transferCategoryChangeUsePercent") val transferCategoryChangeUsePercent: Int,
    @SerializedName("transportationCategoryChangePercent") val transportationCategoryChangePercent: Int, //교통비
    @SerializedName("transportationCategoryChangeBudget") val transportationCategoryChangeBudget: Int,
    @SerializedName("transportationCategoryChangeUsePercent") val transportationCategoryChangeUsePercent: Int,
    @SerializedName("medicalCategoryChangePercent") val medicalCategoryChangePercent: Int, //의료비
    @SerializedName("medicalCategoryChangeBudget") val medicalCategoryChangeBudget: Int,
    @SerializedName("medicalCategoryChangeUsePercent") val medicalCategoryChangeUsePercent: Int,
    @SerializedName("insuranceCategoryChangePercent") val insuranceCategoryChangePercent: Int, //보험비
    @SerializedName("insuranceCategoryChangeBudget") val insuranceCategoryChangeBudget: Int,
    @SerializedName("insuranceCategoryChangeUsePercent") val insuranceCategoryChangeUsePercent: Int,
    @SerializedName("subCategoryChangePercent") val subCategoryChangePercent: Int, //구독비
    @SerializedName("subCategoryChangeBudget") val subCategoryChangeBudget: Int,
    @SerializedName("subCategoryChangeUsePercent") val subCategoryChangeUsePercent: Int,
    @SerializedName("eduCategoryChangePercent") val eduCategoryChangePercent: Int, //교육비
    @SerializedName("eduCategoryChangeBudget") val eduCategoryChangeBudget: Int,
    @SerializedName("eduCategoryChangeUsePercent") val eduCategoryChangeUsePercent: Int,
    @SerializedName("mobileCategoryChangePercent") val mobileCategoryChangePercent: Int, //모바일페이
    @SerializedName("mobileCategoryChangeBudget") val mobileCategoryChangeBudget: Int,
    @SerializedName("mobileCategoryChangeUsePercent") val mobileCategoryChangeUsePercent: Int,
    @SerializedName("othersCategoryChangePercent") val othersCategoryChangePercent: Int, //기타
    @SerializedName("othersCategoryChangeBudget") val othersCategoryChangeBudget: Int,
    @SerializedName("othersCategoryChangeUsePercent") val othersCategoryChangeUsePercent: Int,

)
