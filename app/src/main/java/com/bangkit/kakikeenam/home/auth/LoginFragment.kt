package com.bangkit.kakikeenam.home.auth

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bangkit.kakikeenam.R
import com.bangkit.kakikeenam.databinding.FragmentLoginBinding
import com.bangkit.kakikeenam.utils.hideProgressDialog
import com.bangkit.kakikeenam.utils.showErrSnackBar
import com.bangkit.kakikeenam.utils.showProgressDialog
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.registerTxt.setOnClickListener(this)
        binding.forgetPassword.setOnClickListener(this)
        binding.loginBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.register_txt -> {
                findNavController().navigate(R.id.action_homeFragment_to_registerFragment)
            }
            R.id.login_btn -> {
                loginUser()
            }
            R.id.forget_password -> {
                findNavController().navigate(R.id.action_homeFragment_to_forgotPasswordFragment)
            }
        }

    }

    private fun validateLogin(): Boolean {
        with(binding.loginRoot){
            return when {
                TextUtils.isEmpty(binding.emailLogin.text.toString().trim{it <= ' '}) -> {
                    showErrSnackBar(binding.loginRoot, resources.getString(R.string.err_email), true)
                    false
                }
                TextUtils.isEmpty(binding.passLogin.text.toString().trim{it <= ' '}) -> {
                    showErrSnackBar(binding.loginRoot, resources.getString(R.string.err_pass), true)
                    false
                }
                else -> {
                    true
                }
            }
        }
    }
    private fun loginUser() {
        // check field valid
        if (validateLogin()){

            binding.loginRoot.showProgressDialog()

            val email: String = binding.emailLogin.text.toString().trim{ it <= ' '}
            val password: String = binding.passLogin.text.toString().trim{ it <= ' '}

            // Create instance and login user with email and password
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    hideProgressDialog()
                    // if success
                    if (task.isSuccessful) {
                        binding.loginRoot.showErrSnackBar(binding.loginRoot,
                            "Login berhasil",
                            false
                        )
                        // login to dashboard
                        findNavController().navigate(R.id.action_homeFragment_to_dashboardFragment)
                    } else {
                        // if failed
                        binding.root.showErrSnackBar(binding.loginRoot,
                            task.exception?.message.toString(),
                            true
                        )
                    }
                }
        }
    }
}