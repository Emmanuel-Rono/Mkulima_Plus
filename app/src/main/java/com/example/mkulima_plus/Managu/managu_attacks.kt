package com.example.mkulima_plus.Managu

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.Isaka.Isaka_Adapter
import com.example.mkulima_plus.Isaka.Isaka_DataClass
import com.example.mkulima_plus.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore

class managu_attacks : Fragment(R.layout.fragment_managu_attacks) {
    private lateinit var dbRef: FirebaseFirestore
    var AttacksData = ArrayList<Managu_DataClass>()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Managu_Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.Attacks_managu_Recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.hasFixedSize()
        adapter = Managu_Adapter(requireContext(),AttacksData)
        getAboutData()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getAboutData() {
        dbRef = FirebaseFirestore.getInstance() //get the database instance
        dbRef.collection("Managu_Attacks").addSnapshotListener { value, error ->
            if (error != null) {
                Log.e("Firestone error ", error.message.toString())
            }
            for (dc: DocumentChange in value?.documentChanges!!) {
                if (dc.type == DocumentChange.Type.ADDED) {
                    AttacksData.add(dc.document.toObject(Managu_DataClass::class.java))
                }
            }
            adapter.notifyDataSetChanged()
        }
        recyclerView.adapter = adapter
    }
}