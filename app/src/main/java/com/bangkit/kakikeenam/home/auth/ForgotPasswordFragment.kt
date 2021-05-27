package com.bangkit.kakikeenam.home.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kakikeenam.R
import com.bangkit.kakikeenam.databinding.FragmentForgotPasswordBinding
import com.bangkit.kakikeenam.utils.hideProgressDialog
import com.bangkit.kakikeenam.utils.showErrSnackBar
import com.bangkit.kakikeenam.utils.showProgressDialog
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_homeFragment)
        }

        binding.sendBtn.setOnClickListener {
            val email: String = binding.emailForgot.text.toString().trim{it <= ' '}
            if (email.isEmpty()){
                binding.forgotRoot.showErrSnackBar(binding.forgotRoot, resources.getString(R.string.err_email), true)
            }else {
                binding.forgotRoot.showProgressDialog()
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{ task ->
                        hideProgressDialog()
                        if (task.isSuccessful){
                            binding.forgotRoot.showErrSnackBar(binding.forgotRoot,
                            resources.getString(R.string.email_send), false)
                            findNavController().navigate(R.id.action_forgotPasswordFragment_to_homeFragment)
                        }else {
                            binding.forgotRoot.showErrSnackBar(binding.forgotRoot,
                                task.exception?.message.toString(),
                                true
                            )
                        }
                    }
            }
        }
    }

}