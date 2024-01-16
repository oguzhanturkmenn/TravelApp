package com.example.travelapp.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.travelapp.databinding.FragmentOnboardBinding
import com.example.travelapp.util.fullscreenMode


class OnboardFragment : Fragment() {

    /**
     * Variables
     */
    private var _binding: FragmentOnboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
    }

    private fun initialize() {
        fullscreenMode()

        prepareViewAdapter()
    }

    private fun prepareViewAdapter() {

        val fragments = listOf(OnboardFirstPage(), OnboardSecondPage(), OnboardThirdPage()) // Replace with your fragment instances
        val adapter = OnboardAdapter(fragments, requireActivity())
        binding.onboardViewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.onboardViewPager)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}