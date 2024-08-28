package com.example.why1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.why1.appdata.AppData
import com.example.why1.auth.NetworkConnection
import com.example.why1.databinding.ActivityMainBinding
import com.example.why1.databinding.ActivityMonitoringBinding
import com.example.why1.retropit.MainResonse
import com.example.why1.retropit.ManageService
import com.example.why1.retropit.MonitorRequest
import com.example.why1.retropit.SmonitorRsponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MonitoringActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMonitoringBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoring)
        val userId = AppData.S_userId

        // binding 초기화는 생활화합시다 제발 맨날 터지네
        binding = DataBindingUtil.setContentView(this,R.layout.activity_monitoring)
        binding.innerButtongo2.setOnClickListener {
            val intent = Intent(this, Monitoring_innerActivity::class.java)
            startActivity(intent)
        }

        //secure무시, 리트로핏 통신까지
        val okHttpClient = NetworkConnection.createOkHttpClient()
        val retrofit = NetworkConnection.createRetrofit(okHttpClient, "https://d6ff-122-42-81-30.ngrok-free.app")
        val ActService = retrofit.create(ManageService::class.java)

        val dynamicUrl3 = "api/v1/report/summary"
        val call2 = ActService.smonitor(dynamicUrl3, MonitorRequest(userId,"20240828"))
        call2.enqueue(object : Callback<SmonitorRsponse> {
            override fun onResponse(call: Call<SmonitorRsponse>, response: Response<SmonitorRsponse>) {
                val logs = response.body()
                Log.d("monitor_s Result: ", "Response: $logs")
                val money = response.body()?.totalConsumption
                val bpct = response.body()?.percentageOfBudget
                val cpct = response.body()?.percentageChange
                val gpt = response.body()?.gptAdvice
                val high = response.body()?.highestCategory
                val hpct = response.body()?.highestCategoryPercent
                val low = response.body()?.lowestCategory
                val lpct = response.body()?.lowestCategoryPercent
                if (logs != null){
                    binding.mText7.text="현재 "+money+" 원 사용 "+"("+bpct+"%)"
                    binding.mText8.text="저번달 대비 "+cpct+"% 증가"
                    binding.mText9.text=gpt
                    binding.mText10.text="최고 소비 카테고리: "+high
                    binding.mText11.text="저번 달 대비 "+hpct+"% 증가"
                    binding.mText12.text="최저 소비 카테고리: "+low
                    binding.mText13.text="저번 달 대비 "+lpct+"% 감소"

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
                if(hpct == 999999){
                    binding.mText8.text="저번달의 데이터가 존재하지 않습니다."
                    binding.mText11.text="저번달의 데이터가 존재하지 않습니다."
                    binding.mText13.text="저번달의 데이터가 존재하지 않습니다."
                }
                //9999999 면 이번달 최초사용 태그
                else if(hpct == 9999999){
                    binding.mText8.text="최초 사용 태그"
                    binding.mText11.text="최초 사용 태그"
                    binding.mText13.text="최초 사용 태그"
                }
            }
            override fun onFailure(call: Call<SmonitorRsponse>, t: Throwable) {
                Log.e("error", "Failed to send request to server. Error: ${t.message}")
            }
        })

    }

    fun onBubbleUserClick2(view: View) { // 배경 눌리면 이동하게, 레이아웃에서 설정하고 함수 호출하게함
        val intent = Intent(this, moneyActivity::class.java)
        startActivity(intent)
    }
}