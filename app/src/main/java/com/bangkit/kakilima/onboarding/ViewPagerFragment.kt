package com.bangkit.kakilima.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.kakilima.R
import com.bangkit.kakilima.onboarding.screen.FirstScreenFragment
import com.bangkit.kakilima.onboarding.screen.SecondScreenFragment
import com.bangkit.kakilima.onboarding.screen.ThirdScreenFragment


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )

        val adapter = ViewPagerBoardAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )
        view.findViewById<ViewPager2>(R.id.viewPager)
            .adapter = adapter

        return view
    }
}