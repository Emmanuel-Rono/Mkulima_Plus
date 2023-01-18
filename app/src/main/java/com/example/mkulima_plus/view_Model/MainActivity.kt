package com.example.mkulima_plus.view_Model

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.mkulima_plus.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val test: Button =findViewById(R.id.button)

            test.setOnClickListener {
                val intent=Intent(this,CropsActivity::class.java)
                startActivity(intent)
                Log.d(TAG, "Error here")

            }
        }


    }
