package com.bangkit.kakilima.home.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bangkit.kakilima.R
import com.bangkit.kakilima.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginTxt.setOnClickListener(this)
        binding.backToLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.login_txt -> {
                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            }
            R.id.back_to_login -> {
                findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
            }
        }
    }
}