package com.version1.badroomAdmin.ui.account

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.version1.badroomAdmin.databinding.FragmentCreateAccountBinding

class CreateAccountFragment : Fragment() {

    private lateinit var binding: FragmentCreateAccountBinding
    private lateinit var viewModel: CreateAccountViewModel
    val db = Firebase.firestore
    var loading: ProgressBar? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateAccountBinding.inflate(layoutInflater, container, false)
        loading = binding.loading
        binding.btnLogin1.setOnClickListener {
            login()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreateAccountViewModel::class.java)

    }
    private fun login() {
        val username = binding.username.text.toString()
        val email = binding.email.text.toString()
        val phone = binding.phone.text.toString()
        if (username.isEmpty()) binding.username.error = "መለያ ስም ያስገቡ"
        if (phone.isEmpty()) binding.phone.error = "ስልክ ቁጥር ያስገቡ"
        if (email.isEmpty()) binding.email.error = "ኢሜል አድራሻ  ያስገቡ"
        if (checkValidation()) {
            loading!!.visibility = View.VISIBLE
            val user = hashMapOf(
                "username" to binding.username.text.toString(),
                "email" to binding.email.text.toString(),
                "phonenumber" to binding.phone.text.toString(),
                "password" to "123",
                "role" to "officer"
            )
            // Add a new document with a generated ID
            db.collection("accounts")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    clearFields()
                    loading!!.visibility = View.GONE
                    Toast.makeText(context, "አካውንት ተመዝግቧል!!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Log.w("weldsh", "Error adding document", e)
                }
        }
    }
    private fun checkValidation(): Boolean {
        val username = binding.username.text.toString()
        val phone = binding.phone.text.toString()
        val email = binding.email.text.toString()
        if (username.isEmpty() && phone.isEmpty() && email.isEmpty()) {
            return false
        }
        return true
    }
    private fun clearFields() {
        binding.username.text?.clear()
        binding.phone.text?.clear()
        binding.email.text?.clear()
    }

}