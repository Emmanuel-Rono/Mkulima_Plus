package com.example.mkulima_plus.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.Adapters.DataModel
import com.example.mkulima_plus.Adapters.my_Adapter
import com.example.mkulima_plus.databinding.FragmentAboutBinding
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore


class About : Fragment() {
    private lateinit var dbRef: FirebaseFirestore
    private lateinit var aboutData: ArrayList<DataModel>
    private lateinit var reccyclerview: RecyclerView
    private lateinit var _binding: FragmentAboutBinding
    private lateinit var adapter: my_Adapter
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onCreate(savedInstanceState)
        reccyclerview = binding.RecyclerviewAbout
        reccyclerview.layoutManager = LinearLayoutManager(this.context)
        reccyclerview.hasFixedSize()
        aboutData = arrayListOf()
        adapter = my_Adapter(aboutData) //object of the adapter and pass the datalist
        //getAboutData()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getAboutData() {
        dbRef = FirebaseFirestore.getInstance() //get the database instance
        dbRef.collection("Saka").addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestone error ", error.message.toString())
            }
            for (dc: DocumentChange in value?.documentChanges!!)
            {
                if (dc.type == DocumentChange.Type.ADDED) {
                    aboutData.add(dc.document.toObject(DataModel::class.java))
                }
            }
            adapter.notifyDataSetChanged()
        }
        reccyclerview.adapter = adapter
    }
}