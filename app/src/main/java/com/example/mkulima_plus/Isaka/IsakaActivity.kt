package com.example.mkulima_plus.Isaka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.MenuProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mkulima_plus.R

class IsakaActivity : AppCompatActivity() {
    lateinit var navcontroller:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crops)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.my_toolbar)
        setSupportActionBar(toolbar)
        title = "Isaka"
        val navhost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView3) as NavHostFragment
        navcontroller = navhost.findNavController()
        toolbar.setupWithNavController(navcontroller)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.tool_bar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId) {
            R.id.fragment_attacks -> {
                navcontroller.navigate(R.id.action_about_to_attacks)
            }
        }
        when (item.itemId) {
            R.id.tips -> {
                navcontroller.navigate(R.id.action_about_to_tips)
            }
        }
        when(item.itemId) {
            R.id.fragment_about -> {
                navcontroller.navigate(R.id.action_tips_to_about)
            }
        }
        return false
    }
}
