package com.example.mkulima_plus.Isaka
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mkulima_plus.R
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestore
class Attacks() : Fragment(R.layout.fragment_attacks)
{
    private lateinit var dbRef: FirebaseFirestore
     var AttacksData=ArrayList<Isaka_Attacks_DataClass>()
    lateinit var recyclerView:RecyclerView
    lateinit var adapter: Isaka_Attacks_Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView=view.findViewById(R.id.Attacks_Recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.hasFixedSize()
        adapter = Isaka_Attacks_Adapter(requireContext(),AttacksData)
        getAboutData()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun getAboutData() {
    dbRef = FirebaseFirestore.getInstance() //get the database instance
    dbRef.collection("Saka").

        addSnapshotListener { value, error ->
    if (error != null) {
        Log.e("Firestone error ", error.message.toString())
    }
    for (dc: DocumentChange in value?.documentChanges!!)
    {
        if (dc.type == DocumentChange.Type.ADDED) {
            AttacksData.add(dc.document.toObject(Isaka_Attacks_DataClass::class.java))
        }
    }
    adapter.notifyDataSetChanged()
}
    recyclerView.adapter = adapter
}
}


