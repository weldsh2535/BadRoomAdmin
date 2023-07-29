package com.version1.badroomAdmin.ui.detail

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.version1.badroomAdmin.databinding.FragmentDetailBinding
import com.version1.badroomAdmin.ui.Dashboard.DashboardViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val model = ViewModelProvider(requireActivity()).get(DashboardViewModel::class.java)

        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        model.fullname.observe(viewLifecycleOwner, Observer { message ->
            binding.fullname.text = message.toString()
        })

        model.kebele.observe(viewLifecycleOwner, Observer { message ->
            binding.kebele.text = message.toString()
        })

        model.roomNumber.observe(viewLifecycleOwner, Observer { message ->
            binding.roomnumber.text = message.toString()
        })

        model.phonenumber.observe(viewLifecycleOwner, Observer { message ->
            binding.phone.text = message
        })

        model.registerDate.observe(viewLifecycleOwner, Observer { message ->
            binding.registerDate.text = message
        })
        model.exitDate.observe(viewLifecycleOwner, Observer { message->
            binding.exitDate.text = message
        })
        model.images.observe(viewLifecycleOwner, Observer { message ->
            //decode base64 string to image
            val imageBytes = Base64.decode(message, Base64.DEFAULT)
            val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            binding.images.setImageBitmap(decodedImage)
        })

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}