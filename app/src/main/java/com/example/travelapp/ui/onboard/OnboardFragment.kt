package com.example.travelapp.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.travelapp.R
import com.example.travelapp.databinding.FragmentOnboardBinding
import com.example.travelapp.util.fullscreenMode
import com.example.travelapp.util.goTo


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
        prepareViewAdapter()

        checkWhichPage()

        goToLoginPage()
    }

    private fun prepareViewAdapter() {
        val fragments = listOf(OnboardFirstPage(), OnboardSecondPage(), OnboardThirdPage())
        val adapter = OnboardAdapter(fragments, requireActivity())
        binding.onboardViewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.onboardViewPager)
    }

    private fun checkWhichPage(){
        binding.onboardViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                if (position == 2) {
                    binding.passButton.animate().alpha(1f).setDuration(500).withStartAction {
                        binding.passButton.visibility = View.VISIBLE
                    }
                } else {
                    binding.passButton.animate().alpha(0f).setDuration(150).withEndAction {
                        binding.passButton.visibility = View.INVISIBLE
                    }
                }
            }
        })
    }

    private fun goToLoginPage(){
        binding.passButton.setOnClickListener {
            Navigation.goTo(requireView(),R.id.action_onboardFragment_to_loginFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}