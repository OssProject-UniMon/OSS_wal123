package com.example.why1

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
        val retrofit = NetworkConnection.createRetrofit(okHttpClient, "https://fb23-110-35-169-230.ngrok-free.app")
        val ActService = retrofit.create(ManageService::class.java)

        val dynamicUrl3 = "api/v1/report/detail"
        val call2 = ActService.dmonitor(dynamicUrl3, MonitorRequest(userId,"20240824"))
        call2.enqueue(object : Callback<DmonitorResponse> {
            override fun onResponse(call: Call<DmonitorResponse>, response: Response<DmonitorResponse>) {
                val logs = response.body()
                Log.d("monitor_d Result: ", "Response: $logs")
                val goals_food = response.body()?.foodCategoryChangeBudget //목표 금액
                val percentage_food = response.body()?.foodCategoryChangeUsePercent // 사용 퍼센트
                val before_food = response.body()?.foodCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText15.text="목표금액: "+goals_food
                    binding.miFoodBm.text="저번달 대비 "+before_food+"% 증가"
                    binding.miFoodP.text="현재"+percentage_food+"%"
                    if (percentage_food != null) { // 막대그래프 업데이트
                        foodPercent = percentage_food
                        val foodProgressBar = findViewById<ProgressBar>(R.id.foodProgressBar)
                        foodProgressBar.progress = foodPercent
                    }
                }
                val goals_cafe = response.body()?.cafeCategoryChangeBudget //목표 금액
                val percentage_cafe = response.body()?.cafeCategoryChangeUsePercent // 사용 퍼센트
                val before_cafe = response.body()?.cafeCategoryChangePercent // 지난달 대비 오른 퍼센트
                if (logs != null){ // 저번달 대비 증가, 감소 판단하는것도 추가해야함
                    binding.miText17.text="목표금액: "+goals_cafe
                    binding.miCafeBm.text="저번달 대비 "+before_cafe+"% 증가"
                    binding.miCafeP.text="현재"+percentage_cafe+"%"
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
                    if (percentage_some != null) { // 막대그래프 업데이트
                        somePercent = percentage_some
                        val someProgressBar = findViewById<ProgressBar>(R.id.someProgressBar)
                        someProgressBar.progress = somePercent
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