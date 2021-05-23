package com.bangkit.kakilima.onboarding.screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.kakilima.R

class  ThirdScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        view.findViewById<AppCompatButton>(R.id.search_btn)
            .setOnClickListener {
                findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
                onBoardingSearch()
            }

        view.findViewById<ImageButton>(R.id.back)
                .setOnClickListener {
                    viewPager?.currentItem = 1
                }

        return view
    }
    private fun onBoardingSearch(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finish",true)
        editor.apply()
    }
}