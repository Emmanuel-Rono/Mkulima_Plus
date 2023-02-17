package com.example.mkulima_plus.view_Model

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.example.mkulima_plus.View.cropsAdapater
import com.example.mkulima_plus.View.cropsModel

class MainActivity : AppCompatActivity() {
    lateinit var Recyclerview: RecyclerView
    lateinit var images: ArrayList<Int>
    lateinit var textname: Array<String>
    lateinit var dataArray:ArrayList<cropsModel>

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val test: Button = findViewById(R.id.button)
        test.setOnClickListener {
            val intent = Intent(this, CropsActivity::class.java)
            startActivity(intent)
            Log.d(TAG, "Error here")
        }

        images = arrayListOf(
            R.drawable.kunde,
            R.drawable.managu,
            R.drawable.isaka2,
            R.drawable.kunde,
            R.drawable.managu,
            R.drawable.isaka2,
            R.drawable.kunde,
            R.drawable.managu,
            R.drawable.isaka2,
            R.drawable.kunde,
            R.drawable.managu,
            R.drawable.isaka2,
            R.drawable.kunde,
            R.drawable.managu,R.drawable.isaka2,
            R.drawable.kunde,
            R.drawable.managu,
            R.drawable.isaka2,

            R.drawable.mrenda
        )
        textname = arrayOf(
            "Kunde",
            "Managu",
            "Isaka",
            "Kunde",
            "Managu",
            "Isaka",
            "Kunde",
            "Managu",
            "Isaka",
            "Kunde",
            "Managu",
            "Isaka",
            "Kunde",
            "Managu",
            "Isaka",
            "Kunde",
            "Managu",
            "Isaka",
            "Mrenda"
        )
        Recyclerview = findViewById(R.id.Recyclerview)
        Recyclerview.layoutManager = GridLayoutManager(this, 3)
        Recyclerview.hasFixedSize()
        dataArray = arrayListOf<cropsModel>()
        getCropData()
        //val adapter=cropsAdapater(dataArray)
        //Recyclerview.adapter =adapter
    }
    fun getCropData() {
        for (x in images.indices) {
           val cropsModel_Obj=cropsModel(images[x],textname[x])
            dataArray.add(cropsModel_Obj)
        }
Recyclerview.adapter= cropsAdapater(dataArray)
    }
}



