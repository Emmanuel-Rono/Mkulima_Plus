package com.example.mkulima_plus.view_Model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.replace
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import androidx.fragment.app.*
import com.example.mkulima_plus.R

class CropsActivity : AppCompatActivity() {

    val FragmentContainer = findViewById<FragmentContainerView>(R.id.fragmentContainerView)
    val ToolBar = findViewById<Toolbar>(R.id.ToolBar)
    val About_Fragment = About()
    val Atack_fragment = Attacks()
    val Tips_Fragment = Tips()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crops)
        //get the views

    }
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if(item.itemId == R.id.Attacks)
                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragmentContainerView, About_Fragment)
                    commit()
                }
            return super.onOptionsItemSelected(item)
        }
    }


