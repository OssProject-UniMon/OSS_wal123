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
        val retrofit = NetworkConnection.createRetrofit(okHttpClient, "https://a48c-110-35-169-230.ngrok-free.app/")
        val ActService = retrofit.create(ManageService::class.java)

        val dynamicUrl3 = "api/v1/report/summary"
        val call2 = ActService.smonitor(dynamicUrl3, MonitorRequest(userId,"20240824"))
        call2.enqueue(object : Callback<SmonitorRsponse> {
            override fun onResponse(call: Call<SmonitorRsponse>, response: Response<SmonitorRsponse>) {
                val logs = response.body()
                Log.d("monitor_s Result: ", "Response: $logs")


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