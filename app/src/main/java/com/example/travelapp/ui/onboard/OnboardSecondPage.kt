package com.example.travelapp.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelapp.databinding.FragmentOnboardSecondPageBinding
import com.example.travelapp.util.fullscreenMode

class OnboardSecondPage : Fragment() {

    /**
     * Variables
     */
    private var _binding: FragmentOnboardSecondPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardSecondPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fullscreenMode()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}