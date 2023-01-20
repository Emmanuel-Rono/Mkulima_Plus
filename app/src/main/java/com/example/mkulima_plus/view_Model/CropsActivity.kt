package com.example.mkulima_plus.view_Model

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
import com.example.mkulima_plus.R
class CropsActivity : AppCompatActivity() {
    val Atack_fragment = Attacks()
    //val About_fragment=About()
            override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crops)
        title="Kotlin"
       //if (savedInstanceState == null) {
           // supportFragmentManager.commit {
              //  setReorderingAllowed(true)

              //  add<About>(R.id.fragmentContainerView)
           // }
        //}
        //Access the Recyclerview
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.tool_bar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId){R.id.fragment_attacks->
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,Atack_fragment)
                .commit()
        }
        return super.onOptionsItemSelected(item)
    }
    }




