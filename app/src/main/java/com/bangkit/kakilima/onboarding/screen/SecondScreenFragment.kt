package com.bangkit.kakilima.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatButton
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.kakilima.R

class SecondScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        view.findViewById<AppCompatButton>(R.id.skip2)
            .setOnClickListener {
                viewPager?.currentItem = 2
            }
        view.findViewById<ImageButton>(R.id.back2)
                .setOnClickListener {
                    viewPager?.currentItem = 0
                }

        return view
    }

}