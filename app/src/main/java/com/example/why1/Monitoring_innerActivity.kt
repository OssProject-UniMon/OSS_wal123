package com.example.why1

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import com.example.why1.appdata.AppData
import com.example.why1.auth.NetworkConnection
import com.example.why1.databinding.ActivityMonitoringBinding
import com.example.why1.databinding.ActivityMonitoringInnerBinding
import com.example.why1.retropit.DmonitorResponse
import com.example.why1.retropit.ManageService
import com.example.why1.retropit.MonitorRequest
import com.example.why1.retropit.SmonitorRsponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Monitoring_innerActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMonitoringInnerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoring_inner)
        val userId = AppData.S_userId
        binding = DataBindingUtil.setContentView(this,R.layout.activity_monitoring_inner)

        //막대그래프 변수 초기화
        var foodPercent = 90
        var cafePercent = 75
        var shoppingPercent = 50
        var etcPercent = 30
        var somePercent = 25
        var personPercent = 25
        var transPercent = 25
        var mediPercent = 25
        var subPercent = 25
        var munPercent = 25
        var eduePercent = 25
        var bohumPercent = 25
        var sukPercent = 25
        var sportsPercent = 25
        var orakPercent = 25


        //secure무시, 리트로핏 통신까지
        val okHttpClient = NetworkConnection.createOkHttpClient()
        val retrofit = NetworkConnection.createRetrofit(okHttpClient, "https://d6ff-122-42-81-30.ngrok-free.app")
        val ActService = retrofit.create(ManageService::class.java)

        val dynamicUrl3 = "api/v1/report/detail"
        val call2 = ActService.dmonitor(dynamicUrl3, MonitorRequest(userId,"20240828"))
        call2.enqueue(object : Callback<DmonitorResponse> {
            override fun onResponse(call: Call<DmonitorResponse>, response: Response<DmonitorResponse>) {
                val logs = response.body()
                Log.d("monitor_d Result: ", "Response: $logs")
                val high = response.body()?.highestCategory
                val hper = response.body()?.highestCategoryPercent
                val low = response.body()?.lowestCategory
                val lper = response.body()?.lowestCategoryPercent
                if (logs != null){
                    binding.miText10.text="최고 소비 카테고리: "+high
                    binding.miText11.text="전달 대비 "+hper+"% 증가"
                    binding.miText12.text="최저 소비 카테고리 "+low+"% 증가"
                    binding.miText13.text="전달 대비 "+lper+"% 증가"
                    if(hper == 9999999){
                        binding.miText11.text="이번달 최초 사용 태그"
                        if(lper == 9999999){
                            binding.miText13.text="이번달 최초 사용 태그"
                        }
                    }
                    else if(lper == 9999999){
                        binding.miText13.text="이번달 최초 사용 태그"
                    }
                    if(high == "문화"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_mun)
                    }
                    else if(high == "카페"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_2)
                    }
                    else if(high == "음식점"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_4)
                    }
                    else if(high == "잡화소매"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_con)
                    }
                    else if(high == "쇼핑"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_3)
                    }
                    else if(high == "이체"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_b)
                    }
                    else if(high == "교통비"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_bus)
                    }
                    else if(high == "의료비"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_medi)
                    }
                    else if(high == "구독/정기결제"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_net)
                    }
                    else if(high == "교육비"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_edu)
                    }
                    else if(high == "보험비"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_bo)
                    }
                    else if(high == "숙박비"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_suk)
                    }
                    else if(high == "스포츠"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_sports)
                    }
                    else if(high == "오락"){
                        binding.hicon.setBackgroundResource(R.drawable.icon_game)
                    }
                    else{
                        binding.hicon.setBackgroundResource(R.drawable.icon_5)
                    }
                    if(low == "문화"){
                        binding.licon.setBackgroundResource(R.drawable.icon_mun)
                    }
                    else if(low == "카페"){
                        binding.licon.setBackgroundResource(R.drawable.icon_2)
                    }
                    else if(low == "음식점"){
                        binding.licon.setBackgroundResource(R.drawable.icon_4)
                    }
                    else if(low == "잡화소매"){
                        binding.licon.setBackgroundResource(R.drawable.icon_con)
                    }
                    else if(low == "쇼핑"){
                        binding.licon.setBackgroundResource(R.drawable.icon_3)
                    }
                    else if(low == "이체"){
                        binding.licon.setBackgroundResource(R.drawable.icon_b)
                    }
                    else if(low == "교통비"){
                        binding.licon.setBackgroundResource(R.drawable.icon_bus)
                    }
                    else if(low == "의료비"){
                        binding.licon.setBackgroundResource(R.drawable.icon_medi)
                    }
                    else if(low == "구독/정기결제"){
                        binding.licon.setBackgroundResource(R.drawable.icon_net)
                    }
                    else if(low == "교육비"){
                        binding.licon.setBackgroundResource(R.drawable.icon_edu)
                    }
                    else if(low == "보험비"){
                        binding.licon.setBackgroundResource(R.drawable.icon_bo)
                    }
                    else if(low == "숙박비"){
                        binding.licon.setBackgroundResource(R.drawable.icon_suk)
                    }
                    else if(low == "스포츠"){
                        binding.licon.setBackgroundResource(R.drawable.icon_sports)
                    }
                    else if(low == "오락"){
                        binding.licon.setBackgroundResource(R.drawable.icon_game)
                    }
                    else{
                        binding.licon.setBackgroundResource(R.drawable.icon_5)
                    }
                }
                val goals_food = response.body()?.foodCategoryChangeBudget //목표 금액
                val percentage_food = response.body()?.foodCategoryChangeUsePercent // 사용 퍼센트
                val before_food = response.body()?.foodCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText15.text="목표금액: "+goals_food
                    binding.miFoodBm.text="저번달 대비 "+before_food+"% 증가"
                    binding.miFoodP.text="현재"+percentage_food+"%"
                    binding.miFoodBm.text="이번달 최초 사용 태그" //일단 임시로, 나중에 이프엘스로 바꿔
                    if (percentage_food != null) { // 막대그래프 업데이트
                        foodPercent = percentage_food
                        val foodProgressBar = findViewById<ProgressBar>(R.id.foodProgressBar)
                        foodProgressBar.progress = foodPercent
                        if(foodPercent>80){
                            binding.foodProgressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#FF5722"))
                        }
                        else if(foodPercent>50){
                            binding.foodProgressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#FFC107"))
                        }
                        else if(foodPercent>25){
                            binding.foodProgressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#9C27B0"))
                        }
                        else{
                            binding.foodProgressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#4CAF50"))
                        }
                    }
                }
                val goals_cafe = response.body()?.cafeCategoryChangeBudget //목표 금액
                val percentage_cafe = response.body()?.cafeCategoryChangeUsePercent // 사용 퍼센트
                val before_cafe = response.body()?.cafeCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText17.text="목표금액: "+goals_cafe
                    binding.miCafeBm.text="저번달 대비 "+before_cafe+"% 증가"
                    binding.miCafeP.text="현재"+percentage_cafe+"%"
                    binding.miCafeBm.text="이번달 최초 사용 태그"
                    if (percentage_cafe != null) { // 막대그래프 업데이트
                        cafePercent = percentage_cafe
                        val cafeProgressBar = findViewById<ProgressBar>(R.id.cafeProgressBar)
                        cafeProgressBar.progress = cafePercent
                    }
                }
                val goals_shopping = response.body()?.shoppingCategoryChangeBudget //목표 금액
                val percentage_shopping = response.body()?.shoppingCategoryChangeUsePercent // 사용 퍼센트
                val before_shopping = response.body()?.shoppingCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText19.text="목표금액: "+goals_shopping
                    binding.miShopBm.text="저번달 대비 "+before_shopping+"% 증가"
                    binding.miShopP.text="현재"+percentage_shopping+"%"
                    binding.miShopBm.text="이번달 최초 사용 태그"
                    if (percentage_shopping != null) { // 막대그래프 업데이트
                        shoppingPercent = percentage_shopping
                        val shoppingProgressBar = findViewById<ProgressBar>(R.id.shoppingProgressBar)
                        shoppingProgressBar.progress = shoppingPercent
                    }
                }
                val goals_etc = response.body()?.othersCategoryChangeBudget //목표 금액
                val percentage_etc = response.body()?.othersCategoryChangeUsePercent // 사용 퍼센트
                val before_etc = response.body()?.othersCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText21.text="목표금액: "+goals_etc
                    binding.miElseBm.text="저번달 대비 "+before_etc+"% 증가"
                    binding.miElseP.text="현재"+percentage_etc+"%"
                    binding.miElseBm.text="이번달 최초 사용 태그"
                    if (percentage_etc != null) { // 막대그래프 업데이트
                        etcPercent = percentage_etc
                        val etcProgressBar = findViewById<ProgressBar>(R.id.etcProgressBar)
                        etcProgressBar.progress = etcPercent
                    }
                }
                val goals_person = response.body()?.transferCategoryChangeBudget //목표 금액
                val percentage_person = response.body()?.transferCategoryChangeUsePercent // 사용 퍼센트
                val before_person = response.body()?.transferCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText25.text="목표금액: "+goals_person
                    binding.miPersonBm.text="저번달 대비 "+before_person+"% 증가"
                    binding.miPersonP.text="현재"+percentage_person+"%"
                    binding.miPersonBm.text="이번달 최초 사용 태그"
                    if (percentage_person != null) { // 막대그래프 업데이트
                        personPercent = percentage_person
                        val personProgressBar = findViewById<ProgressBar>(R.id.personProgressBar)
                        personProgressBar.progress = personPercent
                    }
                }
                val goals_trans = response.body()?.transferCategoryChangeBudget //목표 금액
                val percentage_trans = response.body()?.transferCategoryChangeUsePercent // 사용 퍼센트
                val before_trans = response.body()?.transferCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText27.text="목표금액: "+goals_trans
                    binding.miTransBm.text="저번달 대비 "+before_trans+"% 증가"
                    binding.miTransP.text="현재"+percentage_trans+"%"
                    binding.miTransBm.text="이번달 최초 사용 태그"
                    if (percentage_trans != null) { // 막대그래프 업데이트
                        transPercent = percentage_trans
                        val transProgressBar = findViewById<ProgressBar>(R.id.transProgressBar)
                        transProgressBar.progress = transPercent
                    }
                }
                val goals_some = response.body()?.retailCategoryChangeBudget //목표 금액
                val percentage_some = response.body()?.retailCategoryChangeUsePercent // 사용 퍼센트
                val before_some = response.body()?.retailCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText23.text="목표금액: "+goals_some
                    binding.miSomeBm.text="저번달 대비 "+before_some+"% 증가"
                    binding.miSomeP.text="현재"+percentage_some+"%"
                    binding.miSomeBm.text="이번달 최초 사용 태그"
                    if (percentage_some != null) { // 막대그래프 업데이트
                        somePercent = percentage_some
                        val someProgressBar = findViewById<ProgressBar>(R.id.someProgressBar)
                        someProgressBar.progress = somePercent
                    }
                }
                val goals_sub = response.body()?.subCategoryChangeBudget //목표 금액
                val percentage_sub = response.body()?.subCategoryChangeUsePercent // 사용 퍼센트
                val before_sub = response.body()?.subCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText32.text="목표금액: "+goals_sub
                    binding.miSubBm.text="저번달 대비 "+before_sub+"% 증가"
                    binding.miSubP.text="현재"+percentage_sub+"%"
                    binding.miSubBm.text="이번달 최초 사용 태그"
                    if (percentage_sub != null) { // 막대그래프 업데이트
                        subPercent = percentage_sub
                        val subProgressBar = findViewById<ProgressBar>(R.id.subProgressBar)
                        subProgressBar.progress = subPercent
                    }
                }
                val goals_medi = response.body()?.medicalCategoryChangeBudget //목표 금액
                val percentage_medi = response.body()?.medicalCategoryChangeUsePercent // 사용 퍼센트
                val before_medi = response.body()?.medicalCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText29.text="목표금액: "+goals_medi
                    binding.miMediBm.text="저번달 대비 "+before_medi+"% 증가"
                    binding.miMediP.text="현재"+percentage_medi+"%"
                    binding.miMediBm.text="이번달 최초 사용 태그"
                    if (percentage_medi != null) { // 막대그래프 업데이트
                        mediPercent = percentage_medi
                        val mediProgressBar = findViewById<ProgressBar>(R.id.mediProgressBar)
                        mediProgressBar.progress = mediPercent
                    }
                }
                val goals_mun = response.body()?.cultureCategoryChangeBudget //목표 금액
                val percentage_mun = response.body()?.cultureCategoryChangeUsePercent // 사용 퍼센트
                val before_mun = response.body()?.cultureCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText34.text="목표금액: "+goals_mun
                    binding.miMunBm.text="저번달 대비 "+before_mun+"% 증가"
                    binding.miMunP.text="현재"+percentage_mun+"%"
                    binding.miMunBm.text="이번달 최초 사용 태그"
                    if (percentage_mun != null) { // 막대그래프 업데이트
                        munPercent = percentage_mun
                        val munProgressBar = findViewById<ProgressBar>(R.id.munProgressBar)
                        munProgressBar.progress = munPercent
                    }
                }
                val goals_edue = response.body()?.eduCategoryChangeBudget //목표 금액
                val percentage_edue = response.body()?.eduCategoryChangeUsePercent // 사용 퍼센트
                val before_edue = response.body()?.eduCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText36.text="목표금액: "+goals_edue
                    binding.miEdueBm.text="저번달 대비 "+before_edue+"% 증가"
                    binding.miEdueP.text="현재"+percentage_edue+"%"
                    binding.miEdueBm.text="이번달 최초 사용 태그"
                    if (percentage_edue != null) { // 막대그래프 업데이트
                        eduePercent = percentage_edue
                        val edueProgressBar = findViewById<ProgressBar>(R.id.edueProgressBar)
                        edueProgressBar.progress = eduePercent
                    }
                }
                val goals_bohum = response.body()?.insuranceCategoryChangeBudget //목표 금액
                val percentage_bohum = response.body()?.insuranceCategoryChangeUsePercent // 사용 퍼센트
                val before_bohum = response.body()?.insuranceCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText38.text="목표금액: "+goals_bohum
                    binding.miBohumBm.text="저번달 대비 "+before_bohum+"% 증가"
                    binding.miBohumP.text="현재"+percentage_bohum+"%"
                    binding.miBohumBm.text="이번달 최초 사용 태그"
                    if (percentage_bohum != null) { // 막대그래프 업데이트
                        bohumPercent = percentage_bohum
                        val bohumProgressBar = findViewById<ProgressBar>(R.id.bohumProgressBar)
                        bohumProgressBar.progress = bohumPercent
                    }
                }
                val goals_suk = response.body()?.accommodationCategoryChangeBudget //목표 금액
                val percentage_suk = response.body()?.accommodationCategoryChangeUsePercent // 사용 퍼센트
                val before_suk = response.body()?.accommodationCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText40.text="목표금액: "+goals_suk
                    binding.miSukBm.text="저번달 대비 "+before_suk+"% 증가"
                    binding.miSukP.text="현재"+percentage_suk+"%"
                    binding.miSukBm.text="이번달 최초 사용 태그"
                    if (percentage_suk != null) { // 막대그래프 업데이트
                        sukPercent = percentage_suk
                        val sukProgressBar = findViewById<ProgressBar>(R.id.sukProgressBar)
                        sukProgressBar.progress = sukPercent
                    }
                }
                val goals_sports = response.body()?.sportsCategoryChangeBudget //목표 금액
                val percentage_sports = response.body()?.sportsCategoryChangeUsePercent // 사용 퍼센트
                val before_sports = response.body()?.sportsCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText42.text="목표금액: "+goals_sports
                    binding.miSportsBm.text="저번달 대비 "+before_sports+"% 증가"
                    binding.miSportsP.text="현재"+percentage_sports+"%"
                    binding.miSportsBm.text="이번달 최초 사용 태그"
                    if (percentage_sports != null) { // 막대그래프 업데이트
                        sportsPercent = percentage_sports
                        val sportsProgressBar = findViewById<ProgressBar>(R.id.sportsProgressBar)
                        sportsProgressBar.progress = sportsPercent
                    }
                }
                val goals_orak = response.body()?.entertainmentCategoryChangeBudget //목표 금액
                val percentage_orak = response.body()?.entertainmentCategoryChangeUsePercent // 사용 퍼센트
                val before_orak = response.body()?.entertainmentCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText44.text="목표금액: "+goals_orak
                    binding.miOrakBm.text="저번달 대비 "+before_orak+"% 증가"
                    binding.miOrakP.text="현재"+percentage_orak+"%"
                    binding.miOrakBm.text="이번달 최초 사용 태그"
                    if (percentage_orak != null) { // 막대그래프 업데이트
                        orakPercent = percentage_orak
                        val orakProgressBar = findViewById<ProgressBar>(R.id.orakProgressBar)
                        orakProgressBar.progress = orakPercent
                    }
                }
            }
            override fun onFailure(call: Call<DmonitorResponse>, t: Throwable) {
                Log.e("error", "Failed to send request to server. Error: ${t.message}")
            }
        })

        /*

        val foodProgressBar = findViewById<ProgressBar>(R.id.foodProgressBar)
        val cafeProgressBar = findViewById<ProgressBar>(R.id.cafeProgressBar)
        val shoppingProgressBar = findViewById<ProgressBar>(R.id.shoppingProgressBar)
        val etcProgressBar = findViewById<ProgressBar>(R.id.etcProgressBar)

        foodProgressBar.progress = foodPercent
        cafeProgressBar.progress = cafePercent
        shoppingProgressBar.progress = shoppingPercent
        etcProgressBar.progress = etcPercent */
    }
}