package com.example.mkulima_plus.Managu
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mkulima_plus.R

class Managu_Activity : AppCompatActivity() {
    private lateinit var navcontroller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_managu)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.managu_toolbar)
        setSupportActionBar(toolbar)
        title = "Crops"
        val navhost = supportFragmentManager.findFragmentById(R.id.fragmentContainerViewmanagu) as NavHostFragment
        navcontroller = navhost.findNavController()
        toolbar.setupWithNavController(navcontroller)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.managu_tool_bar_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId) {
            R.id.managu_attacks-> {
                navcontroller.navigate(R.id.action_managu_about_to_managu_attacks)
            }
        }
        when (item.itemId) {
            R.id.tips -> {
                navcontroller.navigate(R.id.action_managu_attacks_to_managu_Tips)
            }
        }
        when(item.itemId) {
            R.id.fragment_about -> {
                val intent = Intent(this, managu_about::class.java)
                startActivity(intent)
            }
        }
        return false
    }
}
