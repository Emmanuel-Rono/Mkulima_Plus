package com.example.mkulima_plus.view_Model

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.Model.DataModel
import com.example.mkulima_plus.R
import com.example.mkulima_plus.View.my_Adapter
import com.example.mkulima_plus.databinding.FragmentAboutBinding
import com.google.firebase.database.*


class About : Fragment() {
private lateinit var  dbRef:DatabaseReference
private lateinit var aboutData:ArrayList<DataModel>
private lateinit var reccyclerview:RecyclerView
private lateinit var _binding:FragmentAboutBinding
private lateinit var adapter: my_Adapter
private val binding get()= _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
       reccyclerview=binding.RecyclerviewAbout
            reccyclerview.layoutManager =LinearLayoutManager(context )
            reccyclerview.hasFixedSize()
        aboutData= arrayListOf<DataModel>()
        adapter=my_Adapter(aboutData)
        getAboutData()
    }
    private fun getAboutData(){
        dbRef=FirebaseDatabase.getInstance().getReference("Saka")
        dbRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (aboutdata in snapshot.children) {
                        val data = aboutdata.getValue(DataModel::class.java)
                        aboutData.add(data!!)
                    }
                }
                reccyclerview.adapter=adapter

            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}