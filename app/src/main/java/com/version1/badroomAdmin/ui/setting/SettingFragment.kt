package com.version1.badroomAdmin.ui.setting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.version1.badroomAdmin.databinding.FragmentSettingBinding


class SettingFragment : Fragment() {

    private var _binding: FragmentSettingBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val SettingViewModel =
            ViewModelProvider(this).get(SettingViewModel::class.java)
        _binding = FragmentSettingBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val pref = context?.getSharedPreferences("my_app", Context.MODE_PRIVATE)
        val editor = pref?.edit()
        val roomPrices = pref?.getString("roomPrice", "")
        binding.roomprice.setText(roomPrices)
        binding.txtroomprice.setText(roomPrices)

        binding.btnupdate.setOnClickListener {
            val roomPrice = binding.roomprice.text.toString()
            if (roomPrice.isEmpty()) binding.roomprice.error = "የአልጋ መኝታ ዋጋ አስገባ?"
            if (!roomPrice.isEmpty()) {
                editor?.putString("roomPrice", binding.roomprice.text.toString())
                editor?.apply()
                binding.txtroomprice.setText(binding.roomprice.text.toString())
                binding.roomprice.text?.clear()
                Toast.makeText(context, "ተመዝግቧል!!", Toast.LENGTH_SHORT).show()
            }
        }


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedPreferences = context?.getSharedPreferences("my_app", Context.MODE_PRIVATE)
        val roomPrices = sharedPreferences?.getString("roomPrice", "")
        binding.roomprice.setText(roomPrices)
        binding.txtroomprice.setText(roomPrices)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}