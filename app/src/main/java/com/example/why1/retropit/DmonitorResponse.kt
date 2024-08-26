package com.example.why1.retropit

import com.google.gson.annotations.SerializedName

data class DmonitorResponse(
    @SerializedName("highestCategory") val highestCategory: String,
    @SerializedName("highestCategoryPercent") val highestCategoryPercent: Int,
    @SerializedName("lowestCategory") val lowestCategory: String,
    @SerializedName("lowestCategoryPercent") val lowestCategoryPercent: Int,
    @SerializedName("entertainmentCategoryChangePercent") val entertainmentCategoryChangePercent: Int, //오락비
    @SerializedName("entertainmentCategoryBudget") val entertainmentCategoryChangeBudget: Int,
    @SerializedName("entertainmentCategoryUsePercent") val entertainmentCategoryChangeUsePercent: Int,
    @SerializedName("cultureCategoryChangePercent") val cultureCategoryChangePercent: Int, //문화비
    @SerializedName("cultureCategoryBudget") val cultureCategoryChangeBudget: Int,
    @SerializedName("cultureCategoryUsePercent") val cultureCategoryChangeUsePercent: Int,
    @SerializedName("cafeCategoryChangePercent") val cafeCategoryChangePercent: Int, //카페
    @SerializedName("cafeCategoryBudget") val cafeCategoryChangeBudget: Int,
    @SerializedName("cafeCategoryUsePercent") val cafeCategoryChangeUsePercent: Int,
    @SerializedName("sportsCategoryChangePercent") val sportsCategoryChangePercent: Int, //스포츠
    @SerializedName("sportsCategoryBudget") val sportsCategoryChangeBudget: Int,
    @SerializedName("sportsCategoryUsePercent") val sportsCategoryChangeUsePercent: Int,
    @SerializedName("foodCategoryChangePercent") val foodCategoryChangePercent: Int, //음식점
    @SerializedName("foodCategoryBudget") val foodCategoryChangeBudget: Int,
    @SerializedName("foodCategoryUsePercent") val foodCategoryChangeUsePercent: Int,
    @SerializedName("accommodationCategoryChangePercent") val accommodationCategoryChangePercent: Int, //숙박비
    @SerializedName("accommodationCategoryBudget") val accommodationCategoryChangeBudget: Int,
    @SerializedName("accommodationCategoryUsePercent") val accommodationCategoryChangeUsePercent: Int,
    @SerializedName("retailCategoryChangePercent") val retailCategoryChangePercent: Int,  //잡화소매
    @SerializedName("retailCategoryBudget") val retailCategoryChangeBudget: Int,
    @SerializedName("retailCategoryUsePercent") val retailCategoryChangeUsePercent: Int,
    @SerializedName("shoppingCategoryChangePercent") val shoppingCategoryChangePercent: Int, //쇼핑
    @SerializedName("shoppingCategoryBudget") val shoppingCategoryChangeBudget: Int,
    @SerializedName("shoppingCategoryUsePercent") val shoppingCategoryChangeUsePercent: Int,
    @SerializedName("transferCategoryChangePercent") val transferCategoryChangePercent: Int, //개인이체
    @SerializedName("transferCategoryBudget") val transferCategoryChangeBudget: Int,
    @SerializedName("transferCategoryUsePercent") val transferCategoryChangeUsePercent: Int,
    @SerializedName("transportationCategoryChangePercent") val transportationCategoryChangePercent: Int, //교통비
    @SerializedName("transportationCategoryBudget") val transportationCategoryChangeBudget: Int,
    @SerializedName("transportationCategoryUsePercent") val transportationCategoryChangeUsePercent: Int,
    @SerializedName("medicalCategoryChangePercent") val medicalCategoryChangePercent: Int, //의료비
    @SerializedName("medicalCategoryBudget") val medicalCategoryChangeBudget: Int,
    @SerializedName("medicalCategoryUsePercent") val medicalCategoryChangeUsePercent: Int,
    @SerializedName("insuranceCategoryChangePercent") val insuranceCategoryChangePercent: Int, //보험비
    @SerializedName("insuranceCategoryBudget") val insuranceCategoryChangeBudget: Int,
    @SerializedName("insuranceCategoryUsePercent") val insuranceCategoryChangeUsePercent: Int,
    @SerializedName("subCategoryChangePercent") val subCategoryChangePercent: Int, //구독비
    @SerializedName("subCategoryBudget") val subCategoryChangeBudget: Int,
    @SerializedName("subCategoryUsePercent") val subCategoryChangeUsePercent: Int,
    @SerializedName("eduCategoryChangePercent") val eduCategoryChangePercent: Int, //교육비
    @SerializedName("eduCategoryBudget") val eduCategoryChangeBudget: Int,
    @SerializedName("eduCategoryUsePercent") val eduCategoryChangeUsePercent: Int,
    @SerializedName("mobileCategoryChangePercent") val mobileCategoryChangePercent: Int, //모바일페이
    @SerializedName("mobileCategoryBudget") val mobileCategoryChangeBudget: Int,
    @SerializedName("mobileCategoryUsePercent") val mobileCategoryChangeUsePercent: Int,
    @SerializedName("othersCategoryChangePercent") val othersCategoryChangePercent: Int, //기타
    @SerializedName("othersCategoryBudget") val othersCategoryChangeBudget: Int,
    @SerializedName("othersCategoryUsePercent") val othersCategoryChangeUsePercent: Int,

)
