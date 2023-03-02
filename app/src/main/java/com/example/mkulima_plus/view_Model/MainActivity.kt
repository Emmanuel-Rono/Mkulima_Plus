package com.example.mkulima_plus.view_Model

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.example.mkulima_plus.Isaka.Isaka_Attacks_Adapter
import com.example.mkulima_plus.Isaka.IsakaActivity
import com.example.mkulima_plus.View.cropsAdapater
import com.example.mkulima_plus.View.cropsModel

class MainActivity : AppCompatActivity(),cropsAdapater.OnlickListener{
    lateinit var Recyclerview: RecyclerView
    lateinit var navcontroller:NavController
    lateinit var images: ArrayList<Int>
    lateinit var textname: Array<String>
    lateinit var dataArray: ArrayList<cropsModel>
    lateinit var dataArray2: ArrayList<Isaka_Attacks_Adapter>


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Setting up optionMenu Provider
        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.tool_bar_menu, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return true
            }
        })

        images = arrayListOf(
            R.drawable.kunde,
            R.drawable.managu,
            R.drawable.isaka2
        )
        textname = arrayOf(
            "Kunde",
            "Managu",
            "Isaka"
        )
        Recyclerview = findViewById(R.id.Recyclerview)
        Recyclerview.layoutManager = GridLayoutManager(this, 3)
        Recyclerview.hasFixedSize()
        dataArray = arrayListOf<cropsModel>()
        val adapter = cropsAdapater(dataArray,this@MainActivity)
        Recyclerview.adapter = adapter
        for (x in images.indices) {
            val cropsModel_Obj = cropsModel(images[x], textname[x])
            dataArray.add(cropsModel_Obj)
        }
    }

    override fun onclick(position: Int) {
       when(position )
       {
           0->
           {
                   startActivity(Intent(this, IsakaActivity::class.java))

           }
           1->
           {
               startActivity(Intent(this, IsakaActivity::class.java))
           }
           2->
           {
               startActivity(Intent(this, IsakaActivity::class.java))
           }

           }
       }

    }

