package com.example.rx_in_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rx_in_android.rx_bus.BehaviorSubjectActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_debounce.setOnClickListener {
            startActivity(Intent(this, DebounceActivity::class.java))
        }
        btn_throttle.setOnClickListener {
            startActivity(Intent(this, ThrottleActivity::class.java))
        }
        btn_buffer.setOnClickListener {
            startActivity(Intent(this, BufferActivity::class.java))
        }
        btn_combineLasted.setOnClickListener {
            startActivity(Intent(this, CombineLastest::class.java))
        }
        btn_behaviorSubject.setOnClickListener {
            startActivity(Intent(this, BehaviorSubjectActivity::class.java))
        }

    }


}
