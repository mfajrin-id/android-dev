package com.bangkit.kakikeenam.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.kakikeenam.R
import com.bangkit.kakikeenam.onboarding.screen.FirstScreenFragment
import com.bangkit.kakikeenam.onboarding.screen.SecondScreenFragment
import com.bangkit.kakikeenam.onboarding.screen.ThirdScreenFragment


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