package com.version1.badroomAdmin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.version1.badroomAdmin.ui.report.daily.DailyFragment
import com.version1.badroomAdmin.ui.report.monthly.MontlyFragment

class ViewPagerAdapter(fm: FragmentManager, var tabCount: Int): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> DailyFragment()
            1 -> MontlyFragment()
            else -> DailyFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }


    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0){
            return "Daily "
        }else{
            return "Monthly "
        }
    }
}
