package com.example.travelapp.ui.forgetPassword

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.travelapp.R
import com.example.travelapp.databinding.FragmentForgetPasswordBinding
import com.example.travelapp.util.fullscreenMode
import com.example.travelapp.util.goTo
import com.example.travelapp.util.showProgressSnackbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ForgetPasswordFragment : Fragment() {

    /**
     * Variables
     */
    private var _binding: FragmentForgetPasswordBinding? = null
    private val binding get() = _binding!!
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentForgetPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        fullscreenMode()

        goToBack()

        prepareAlertDialog()
    }

    private fun prepareAlertDialog() {
        binding.sendButton.setOnClickListener {

            // Set necessary buttons disable
            binding.sendButton.isEnabled = false
            binding.backButton.isEnabled = false

            // Show snackbar
            requireView().showProgressSnackbar("Giriş sayfasına yönlendiriliyorsunuz..", PROGRESS_SNACKBAR_DURATION)

            // Create alert dialog
            with(MaterialAlertDialogBuilder(requireContext())) {
                val inflater = layoutInflater
                val dialogView = inflater.inflate(R.layout.check_your_email_alert, null)
                setView(dialogView)
                val alertDialog = create()
                alertDialog.show()

                // Navigate after 3 seconds to login page
                handler.postDelayed({
                    alertDialog.dismiss()
                    Navigation.goTo(requireView(), R.id.action_forgetPasswordFragment_to_loginFragment)
                }, HANDLER_NAV_DURATION)
            }
        }
    }

    private fun goToBack() {
        binding.backButton.setOnClickListener {
            Navigation.goTo(requireView(), R.id.action_forgetPasswordFragment_to_loginFragment)
        }
    }

    companion object{
        const val PROGRESS_SNACKBAR_DURATION = 3000
        const val HANDLER_NAV_DURATION = 3000L
    }

    override fun onResume() {
        super.onResume()
        //binding.sendButton.isEnabled = true
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}