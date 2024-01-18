package com.example.travelapp.ui.loginSignup

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.travelapp.R
import com.example.travelapp.databinding.FragmentSignupBinding
import com.example.travelapp.util.fullscreenMode
import com.example.travelapp.util.goTo

class SignupFragment : Fragment() {

    /**
     * Variables
     */
    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        fullscreenMode()

        showPasswordOrHide()

        goToLogin()

        goToBack()
    }

    private fun showPasswordOrHide() {
        binding.showOrHidePasswordImage.setOnClickListener {
            if (binding.passwordET.transformationMethod == PasswordTransformationMethod.getInstance()) {
                // Hide password
                binding.passwordET.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                binding.eyeIcon.setImageResource(R.drawable.eye_on)
            } else {
                // Show password
                binding.passwordET.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.eyeIcon.setImageResource(R.drawable.eye_off)
            }
        }
    }

    private fun goToLogin() {
        binding.loginButton.setOnClickListener {
            Navigation.goTo(requireView(), R.id.action_signupFragment_to_loginFragment)
        }
    }

    private fun goToBack() {
        binding.backButton.setOnClickListener {
            Navigation.goTo(requireView(), R.id.action_signupFragment_to_loginFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}