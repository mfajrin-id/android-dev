package com.bangkit.kakikeenam.home.auth

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kakikeenam.R
import com.bangkit.kakikeenam.databinding.FragmentRegisterBinding
import com.bangkit.kakikeenam.utils.hideProgressDialog
import com.bangkit.kakikeenam.utils.showErrSnackBar
import com.bangkit.kakikeenam.utils.showProgressDialog
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginTxt.setOnClickListener(this)
        binding.backToLogin.setOnClickListener(this)

        binding.registerBtn.setOnClickListener {
            registerUser()
        }
    }

    //function for validate field register
    private fun validateRegistration(): Boolean {
        with(binding.registerRoot){
            return when {
                TextUtils.isEmpty(binding.nameRegister.text.toString().trim{it <= ' '}) -> {
                    showErrSnackBar(binding.registerRoot, resources.getString(R.string.err_name), true)
                    false
                }
                TextUtils.isEmpty(binding.emailRegister.text.toString().trim{it <= ' '}) -> {
                    showErrSnackBar(binding.registerRoot, resources.getString(R.string.err_email), true)
                    false
                }
                TextUtils.isEmpty(binding.passRegister.text.toString().trim{it <= ' '}) -> {
                    showErrSnackBar(binding.registerRoot, resources.getString(R.string.err_pass), true)
                    false
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun registerUser() {
        // check field valid
        if (validateRegistration()){

            binding.registerRoot.showProgressDialog()

            val email: String = binding.emailRegister.text.toString().trim{ it <= ' '}
            val password: String = binding.passRegister.text.toString().trim{ it <= ' '}

            // Create instance and register user with email and password
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    hideProgressDialog()
                    // if success
                    if (task.isSuccessful) {
                        binding.registerRoot.showErrSnackBar(binding.registerRoot,
                            "Registrasi berhasil",
                            false
                        )
                        // register testing
                        findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                    } else {
                        // if failed
                        binding.registerRoot.showErrSnackBar(binding.registerRoot,
                            task.exception?.message.toString(),
                            true
                        )
                        Log.e("register", task.exception?.message.toString())
                    }
                }
        }
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