package com.version1.badroomAdmin.ui.report.daily

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.version1.badroomAdmin.R
import com.version1.badroomAdmin.databinding.FragmentDailyBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DailyFragment : Fragment() {

   private lateinit var binding:FragmentDailyBinding

    private lateinit var viewModel: DailyViewModel
    val db = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDailyBinding.inflate(inflater, container, false)
        val inputDate = Date()
        val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)
        val date = inputFormat.parse(inputDate.toString())
        val outputFormat = SimpleDateFormat("dd/M/yyyy", Locale.US)
        val  currentdate = outputFormat.format(date)
        val loading = binding.loading
        lifecycleScope.launch {
            Log.i("MyTag12","total.toString()")
            loading!!.visibility = View.VISIBLE
            db.collection("users")
                .whereEqualTo("registerDate",currentdate)
                .get()
                .addOnSuccessListener { result ->
                    binding.totalroom.text =  result.size().toString()
                    val pref = context?.getSharedPreferences("my_app", Context.MODE_PRIVATE)
                    val roomPrices = pref?.getString("roomPrice", "")
                    val totalR =  result.size().toString().toInt()
                    var roomP = 350
                    if(!roomPrices!!.isEmpty()) {
                      roomP  = roomPrices.toString().toInt()
                    }
                    val total = totalR * roomP
                    Log.i("MyTag12",total.toString())
                    binding.totalBirr.text = total.toString()
                    loading!!.visibility = View.GONE
                }
                .addOnFailureListener { exception ->
                    Log.w("TAG", "Error getting documents.", exception)
                }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DailyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}