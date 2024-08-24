package com.example.why1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import com.example.why1.appdata.AppData
import com.example.why1.auth.NetworkConnection
import com.example.why1.retropit.DmonitorResponse
import com.example.why1.retropit.ManageService
import com.example.why1.retropit.MonitorRequest
import com.example.why1.retropit.SmonitorRsponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Monitoring_innerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoring_inner)
        val userId = AppData.S_userId

        //secure무시, 리트로핏 통신까지
        val okHttpClient = NetworkConnection.createOkHttpClient()
        val retrofit = NetworkConnection.createRetrofit(okHttpClient, "https://a48c-110-35-169-230.ngrok-free.app/")
        val ActService = retrofit.create(ManageService::class.java)

        val dynamicUrl3 = "api/v1/report/detail"
        val call2 = ActService.dmonitor(dynamicUrl3, MonitorRequest(userId,"20240824"))
        call2.enqueue(object : Callback<DmonitorResponse> {
            override fun onResponse(call: Call<DmonitorResponse>, response: Response<DmonitorResponse>) {
                val logs = response.body()
                Log.d("monitor_s Result: ", "Response: $logs")


            }
            override fun onFailure(call: Call<DmonitorResponse>, t: Throwable) {
                Log.e("error", "Failed to send request to server. Error: ${t.message}")
            }
        })

        val foodPercent = 90
        val cafePercent = 75
        val shoppingPercent = 50
        val etcPercent = 30

        val foodProgressBar = findViewById<ProgressBar>(R.id.foodProgressBar)
        val cafeProgressBar = findViewById<ProgressBar>(R.id.cafeProgressBar)
        val shoppingProgressBar = findViewById<ProgressBar>(R.id.shoppingProgressBar)
        val etcProgressBar = findViewById<ProgressBar>(R.id.etcProgressBar)

        foodProgressBar.progress = foodPercent
        cafeProgressBar.progress = cafePercent
        shoppingProgressBar.progress = shoppingPercent
        etcProgressBar.progress = etcPercent
    }
}