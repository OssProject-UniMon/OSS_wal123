package com.example.why1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.why1.databinding.ActivityMainBinding
import com.example.why1.databinding.ActivityMonitoringBinding

class MonitoringActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMonitoringBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monitoring)

        // binding 초기화는 생활화합시다 제발 맨날 터지네
        binding = DataBindingUtil.setContentView(this,R.layout.activity_monitoring)
        binding.innerButtongo2.setOnClickListener {
            val intent = Intent(this, Monitoring_innerActivity::class.java)
            startActivity(intent)
        }
    }

    fun onBubbleUserClick2(view: View) { // 배경 눌리면 이동하게, 레이아웃에서 설정하고 함수 호출하게함
        val intent = Intent(this, moneyActivity::class.java)
        startActivity(intent)
    }
}