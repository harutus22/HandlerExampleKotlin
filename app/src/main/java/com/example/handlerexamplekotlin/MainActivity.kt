package com.example.handlerexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val handler = object: Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val text = if(msg.what == StaticValues.WHAT) msg.obj.toString() else "There is no message"
            Toast.makeText(this@MainActivity, text, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View){
        Thread(Runnable {
            val text = "Button have been clicked"
            val message = handler.obtainMessage(StaticValues.WHAT, text)
            handler.sendMessage(message)
        }).start()
    }
}
