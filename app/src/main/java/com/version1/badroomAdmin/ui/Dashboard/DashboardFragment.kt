package com.version1.badroomAdmin.ui.Dashboard

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.version1.badroomAdmin.R
import com.version1.badroomAdmin.databinding.FragmentDashboardBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    val db = Firebase.firestore
    var loading: ProgressBar? = null
    var currentdate:String? = null
    var avaliableBedRoom:String? = null
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model =
            ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
       val inputDate = Date()
        val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US)
        val date = inputFormat.parse(inputDate.toString())
       val outputFormat = SimpleDateFormat("dd/M/yyyy", Locale.US)
         currentdate = outputFormat.format(date)

        loading = binding.loading
       lifecycleScope.launch {
           loading!!.visibility = View.VISIBLE
           search(currentdate!!)
       }

        binding.searchDate.setOnClickListener {
            view?.let { it1 -> showDateTimePicker(it1) }
        }

        binding.btnsearch.setOnClickListener {
            loading!!.visibility = View.VISIBLE
           search(binding.searchDate.text.toString())
        }

        binding.frameStackellipseone.setOnClickListener {
            if (!(binding.roomnumber.text.toString().isEmpty())){
                model.images.value = binding.images.text.toString()
                model.userId.value = binding.userId.text.toString()
                model.fullname.value = binding.fullname.text.toString()
                model.kebele.value = binding.kebele.text.toString()
                model.phonenumber.value = binding.phone.text.toString()
                model.roomNumber.value = binding.roomnumber.text.toString()
                model.registerDate.value = binding.registerDate.text.toString()
                model.exitDate.value = binding.exitDate.text.toString()
                findNavController().navigate(R.id.nav_details)
            }

        }
        binding.frameStackellipseoneOne.setOnClickListener {
            if (!(binding.roomnumber2.text.toString().isEmpty())) {
                model.images.value = binding.images2.text.toString()
                model.userId.value = binding.userId2.text.toString()
                model.fullname.value = binding.fullname2.text.toString()
                model.kebele.value = binding.kebele2.text.toString()
                model.phonenumber.value = binding.phone2.text.toString()
                model.roomNumber.value = binding.roomnumber2.text.toString()
                model.registerDate.value = binding.registerDate2.text.toString()
                model.exitDate.value = binding.exitDate2.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }
        binding.frameStackellipseoneTwo.setOnClickListener {
            if (!(binding.roomnumber3.text.toString().isEmpty())) {
                model.images.value = binding.images3.text.toString()
                model.userId.value = binding.userId3.text.toString()
                model.fullname.value = binding.fullname3.text.toString()
                model.kebele.value = binding.kebele3.text.toString()
                model.phonenumber.value = binding.phone3.text.toString()
                model.roomNumber.value = binding.roomnumber3.text.toString()
                model.registerDate.value = binding.registerDate3.text.toString()
                model.exitDate.value = binding.exitDate3.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }

        binding.frameStackellipse4.setOnClickListener {
            if (!(binding.roomnumber4.text.toString().isEmpty())) {
                model.images.value = binding.images4.text.toString()
                model.userId.value = binding.userId4.text.toString()
                model.fullname.value = binding.fullname4.text.toString()
                model.kebele.value = binding.kebele4.text.toString()
                model.phonenumber.value = binding.phone4.text.toString()
                model.roomNumber.value = binding.roomnumber4.text.toString()
                model.registerDate.value = binding.registerDate4.text.toString()
                model.exitDate.value = binding.exitDate4.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }
        binding.frameStackellipse5.setOnClickListener {
            if (!(binding.roomnumber5.text.toString().isEmpty())) {
                model.images.value = binding.images5.text.toString()
                model.userId.value = binding.userId5.text.toString()
                model.fullname.value = binding.fullname5.text.toString()
                model.kebele.value = binding.kebele5.text.toString()
                model.phonenumber.value = binding.phone5.text.toString()
                model.roomNumber.value = binding.roomnumber5.text.toString()
                model.registerDate.value = binding.registerDate5.text.toString()
                model.exitDate.value = binding.exitDate5.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }
        binding.frameStackellipse6.setOnClickListener {
            if (!(binding.roomnumber6.text.toString().isEmpty())) {
                model.images.value = binding.images6.text.toString()
                model.userId.value = binding.userId6.text.toString()
                model.fullname.value = binding.fullname6.text.toString()
                model.kebele.value = binding.kebele6.text.toString()
                model.phonenumber.value = binding.phone6.text.toString()
                model.roomNumber.value = binding.roomnumber6.text.toString()
                model.registerDate.value = binding.registerDate6.text.toString()
                model.exitDate.value = binding.exitDate6.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }
        binding.frameStackellipse7.setOnClickListener {
            if (!(binding.roomnumber7.text.toString().isEmpty())) {
                model.images.value = binding.images7.text.toString()
                model.userId.value = binding.userId7.text.toString()
                model.fullname.value = binding.fullname7.text.toString()
                model.kebele.value = binding.kebele7.text.toString()
                model.phonenumber.value = binding.phone7.text.toString()
                model.roomNumber.value = binding.roomnumber7.text.toString()
                model.registerDate.value = binding.registerDate7.text.toString()
                model.exitDate.value = binding.exitDate7.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }
        binding.frameStackellipse8.setOnClickListener {
            if (!(binding.roomnumber8.text.toString().isEmpty())) {
                model.images.value = binding.images8.text.toString()
                model.userId.value = binding.userId8.text.toString()
                model.fullname.value = binding.fullname8.text.toString()
                model.kebele.value = binding.kebele8.text.toString()
                model.phonenumber.value = binding.phone8.text.toString()
                model.roomNumber.value = binding.roomnumber8.text.toString()
                model.registerDate.value = binding.registerDate8.text.toString()
                model.exitDate.value = binding.exitDate8.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }
        binding.frameStackellipseNign.setOnClickListener {
            if (!(binding.roomnumber9.text.toString().isEmpty())) {
                model.images.value = binding.images9.text.toString()
                model.userId.value = binding.userId9.text.toString()
                model.fullname.value = binding.fullname9.text.toString()
                model.kebele.value = binding.kebele9.text.toString()
                model.phonenumber.value = binding.phone9.text.toString()
                model.roomNumber.value = binding.roomnumber9.text.toString()
                model.registerDate.value = binding.registerDate9.text.toString()
                model.exitDate.value = binding.exitDate9.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }
        binding.frameStackellipse10.setOnClickListener {
            if (!(binding.roomnumber10.text.toString().isEmpty())) {
                model.images.value = binding.images10.text.toString()
                model.userId.value = binding.userId10.text.toString()
                model.fullname.value = binding.fullname10.text.toString()
                model.kebele.value = binding.kebele10.text.toString()
                model.phonenumber.value = binding.phone10.text.toString()
                model.roomNumber.value = binding.roomnumber10.text.toString()
                model.registerDate.value = binding.registerDate10.text.toString()
                model.exitDate.value = binding.exitDate10.text.toString()
                findNavController().navigate(R.id.nav_details)
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun search(date:String){

        db.collection("users")
            //.whereEqualTo("status", 0)
            .whereEqualTo("registerDate",date)
            .get()
            .addOnSuccessListener { result ->
                if (result.size() > 0){
                for (document in result) {
                    val index = document.data["roomnumber"].toString()
                    if (index == "1") {
                        binding.userId.text = document.id
                        binding.fullname.text = document.data["fullname"].toString()
                        binding.kebele.text = document.data["kebele"].toString()
                        binding.phone.text = document.data["phonenumber"].toString()
                        binding.roomnumber.text = document.data["roomnumber"].toString()
                        binding.images.text = document.data["imageUrl"].toString()
                        binding.registerDate.text = document.data["registerDate"].toString()
                        binding.exitDate.text = document.data["exitDate"].toString()
                        binding.viewEllipseOne.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "2") {
                        binding.userId2.text = document.id
                        binding.fullname2.text = document.data["fullname"].toString()
                        binding.kebele2.text = document.data["kebele"].toString()
                        binding.phone2.text = document.data["phonenumber"].toString()
                        binding.roomnumber2.text = document.data["roomnumber"].toString()
                        binding.images2.text = document.data["imageUrl"].toString()
                        binding.registerDate2.text = document.data["registerDate"].toString()
                        binding.exitDate2.text = document.data["exitDate"].toString()
                        binding.viewEllipseOneOne.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "3") {
                        binding.userId3.text = document.id
                        binding.fullname3.text = document.data["fullname"].toString()
                        binding.kebele3.text = document.data["kebele"].toString()
                        binding.phone3.text = document.data["phonenumber"].toString()
                        binding.roomnumber3.text = document.data["roomnumber"].toString()
                        binding.images3.text = document.data["imageUrl"].toString()
                        binding.registerDate3.text = document.data["registerDate"].toString()
                        binding.exitDate3.text = document.data["exitDate"].toString()
                        binding.viewEllipseOneTwo.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "4") {
                        binding.userId4.text = document.id
                        binding.fullname4.text = document.data["fullname"].toString()
                        binding.kebele4.text = document.data["kebele"].toString()
                        binding.phone4.text = document.data["phonenumber"].toString()
                        binding.roomnumber4.text = document.data["roomnumber"].toString()
                        binding.images4.text = document.data["imageUrl"].toString()
                        binding.registerDate4.text = document.data["registerDate"].toString()
                        binding.exitDate4.text = document.data["exitDate"].toString()
                        binding.viewEllipse4.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "5") {
                        binding.userId5.text = document.id
                        binding.fullname5.text = document.data["fullname"].toString()
                        binding.kebele5.text = document.data["kebele"].toString()
                        binding.phone5.text = document.data["phonenumber"].toString()
                        binding.roomnumber5.text = document.data["roomnumber"].toString()
                        binding.images5.text = document.data["imageUrl"].toString()
                        binding.registerDate5.text = document.data["registerDate"].toString()
                        binding.exitDate5.text = document.data["exitDate"].toString()
                        binding.viewEllipse5.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "6") {
                        binding.userId6.text = document.id
                        binding.fullname6.text = document.data["fullname"].toString()
                        binding.kebele6.text = document.data["kebele"].toString()
                        binding.phone6.text = document.data["phonenumber"].toString()
                        binding.roomnumber6.text = document.data["roomnumber"].toString()
                        binding.images6.text = document.data["imageUrl"].toString()
                        binding.registerDate6.text = document.data["registerDate"].toString()
                        binding.exitDate6.text = document.data["exitDate"].toString()
                        binding.viewEllipse6.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "7") {
                        binding.userId7.text = document.id
                        binding.fullname7.text = document.data["fullname"].toString()
                        binding.kebele7.text = document.data["kebele"].toString()
                        binding.phone7.text = document.data["phonenumber"].toString()
                        binding.roomnumber7.text = document.data["roomnumber"].toString()
                        binding.images7.text = document.data["imageUrl"].toString()
                        binding.registerDate7.text = document.data["registerDate"].toString()
                        binding.exitDate7.text = document.data["exitDate"].toString()
                        binding.viewEllipse7.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "8") {
                        binding.userId8.text = document.id
                        binding.fullname8.text = document.data["fullname"].toString()
                        binding.kebele8.text = document.data["kebele"].toString()
                        binding.phone8.text = document.data["phonenumber"].toString()
                        binding.roomnumber8.text = document.data["roomnumber"].toString()
                        binding.images8.text = document.data["imageUrl"].toString()
                        binding.registerDate8.text = document.data["registerDate"].toString()
                        binding.exitDate8.text = document.data["exitDate"].toString()
                        binding.viewEllipse8.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "9") {
                        binding.userId9.text = document.id
                        binding.fullname9.text = document.data["fullname"].toString()
                        binding.kebele9.text = document.data["kebele"].toString()
                        binding.phone9.text = document.data["phonenumber"].toString()
                        binding.roomnumber9.text = document.data["roomnumber"].toString()
                        binding.images9.text = document.data["imageUrl"].toString()
                        binding.registerDate9.text = document.data["registerDate"].toString()
                        binding.exitDate9.text = document.data["exitDate"].toString()
                        binding.viewEllipseNign.setBackgroundResource(R.drawable.click_bed_bd)
                    } else if (index == "10") {
                        binding.userId10.text = document.id
                        binding.fullname10.text = document.data["fullname"].toString()
                        binding.kebele10.text = document.data["kebele"].toString()
                        binding.phone10.text = document.data["phonenumber"].toString()
                        binding.roomnumber10.text = document.data["roomnumber"].toString()
                        binding.images10.text = document.data["imageUrl"].toString()
                        binding.registerDate10.text = document.data["registerDate"].toString()
                        binding.exitDate10.text = document.data["exitDate"].toString()
                        binding.viewEllipse10.setBackgroundResource(R.drawable.click_bed_bd)
                    }
                }
                }else{
                    binding.viewEllipseOne.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipseOneOne.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipseOneTwo.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipse4.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipse5.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipse6.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipse7.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipse8.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipseNign.setBackgroundResource(R.drawable.circle_code)
                    binding.viewEllipse10.setBackgroundResource(R.drawable.circle_code)
                }

                binding.total.text =  result.size().toString()
                loading!!.visibility = View.GONE
            }
            .addOnFailureListener { exception ->
                Log.w("TAG", "Error getting documents.", exception)
            }
    }
    fun showDateTimePicker(view: View) {
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
                    binding.searchDate.setText(formattedDate)
                }, year, month, day)
            }

        if (datePickerDialog != null) {
            datePickerDialog.show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        search(currentdate!!)
    }
}