package com.version1.badroomAdmin.ui.report.monthly

import android.app.DatePickerDialog
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.lifecycleScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.version1.badroomAdmin.R
import com.version1.badroomAdmin.databinding.FragmentMontlyBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MontlyFragment : Fragment() {

   private lateinit var binding:FragmentMontlyBinding
    private lateinit var viewModel: MontlyViewModel
    val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMontlyBinding.inflate(layoutInflater,container,false)
        val loading = binding.loading
        binding.startDate.setOnClickListener {
            view?.let { it1 -> showDateTimePicker(it1,1) }
        }
        binding.endDate.setOnClickListener {
            view?.let { it1 -> showDateTimePicker(it1,2) }
        }
        binding.btnsearch.setOnClickListener {
            loading!!.visibility = View.VISIBLE
            Log.i("MyTag12","total.toString()")
            val startDate = binding.startDate.text.toString()
            val endDate = binding.endDate.text.toString()
            db.collection("users")
                .whereGreaterThanOrEqualTo("registerDate", startDate)
                .whereLessThanOrEqualTo("registerDate", endDate)
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
                  //  Log.i("MyTag12",total.toString())
                    binding.totalBirr.text = total.toString()
                    binding.carview.visibility = View.VISIBLE
                    loading!!.visibility = View.GONE
                }
                .addOnFailureListener { exception ->
                    Log.w("TAG", "Error getting documents.", exception)
                }
        }
        return binding.root
    }

    fun showDateTimePicker(view: View,a:Int) {
        val currentDateTime = Calendar.getInstance()
        val year = currentDateTime.get(Calendar.YEAR)
        val month = currentDateTime.get(Calendar.MONTH)
        val day = currentDateTime.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog =
            context?.let {
                DatePickerDialog(it, { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDateTime = Calendar.getInstance()
                    selectedDateTime.set(selectedYear, selectedMonth, selectedDay)

                    val format = SimpleDateFormat("dd/M/yyyy", Locale.getDefault())
                    val formattedDate = format.format(selectedDateTime.time)
                    if (a == 1) {
                        binding.startDate.setText(formattedDate)
                    } else {
                        binding.endDate.setText(formattedDate)
                    }
                }, year, month, day)
            }

        if (datePickerDialog != null) {
            datePickerDialog.show()
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MontlyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}