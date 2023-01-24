package com.example.mkulima_plus.view_Model

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.*
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mkulima_plus.R
class CropsActivity : AppCompatActivity() {
    val Atack_fragment = Attacks()
    lateinit var navcontroller: NavController
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crops)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        title = "Crops"
        val navhost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navcontroller = navhost.findNavController()
        toolbar.setupWithNavController(navcontroller)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.tool_bar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId){
            R.id.fragment_attacks->{
                Toast.makeText(this,"Attacks clicked",Toast.LENGTH_LONG).show()
                navcontroller.navigate(R.id.action_about_to_attacks)
            }
//            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,Atack_fragment)
//                .commit()
        }
        //when(item.itemId){R.id.fragment_about ->{navcontroller.navigate(R.id.action_about_to_attacks)}
        //}
        when (item.itemId) {
            R.id.tips -> {
                navcontroller.navigate(R.id.action_about_to_tips)
            }
        }
        return false
    }
    }




