package com.example.mkulima_plus.view_Model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mkulima_plus.R


class About : Fragment(R.layout.fragment_about) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(context, "About_Frag , success", Toast.LENGTH_LONG).show()

    }

}