package com.bangkit.kakikeenam.onboarding.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.kakikeenam.R

class FirstScreenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        view.findViewById<AppCompatButton>(R.id.skip1)
            .setOnClickListener {
                viewPager?.currentItem = 1
            }
        return view
    }

}