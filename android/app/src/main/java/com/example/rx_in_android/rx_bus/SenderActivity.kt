package com.example.rx_in_android.rx_bus

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rx_in_android.R
import kotlinx.android.synthetic.main.activity_sender.*

class SenderActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sender)

        btn_send.setOnClickListener {
            RxBus.onNext(SampleDataClass(et_input.text.toString()))
        }


    }
}
