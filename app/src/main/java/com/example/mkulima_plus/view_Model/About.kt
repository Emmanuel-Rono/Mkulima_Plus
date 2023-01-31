package com.example.mkulima_plus.view_Model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.Model.DataModel
import com.example.mkulima_plus.R
import com.example.mkulima_plus.View.my_Adapter
import com.google.firebase.database.*


class About : Fragment(R.layout.fragment_about) {
lateinit var  dbRef:DatabaseReference
lateinit var aboutData:ArrayList<DataModel>
lateinit var recyclerview:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(context, "About_Frag , success", Toast.LENGTH_LONG).show()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerview.findViewById<RecyclerView>(R.id.RecyclerviewAbout)
        recyclerview.layoutManager=LinearLayoutManager(context)
        recyclerview.hasFixedSize()
        aboutData= arrayListOf<DataModel>()
        getAboutData()
    }
    fun getAboutData(){
        dbRef=FirebaseDatabase.getInstance().getReference("Saka")
        dbRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (aboutdata in snapshot.children) {
                        val data = aboutdata.getValue(DataModel::class.java)
                        aboutData.add(data!!)
                    }
                }
                recyclerview.adapter=my_Adapter(aboutData)
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}