package com.ctt.minhastarefas.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ctt.minhastarefas.fragments.DoneFragment
import com.ctt.minhastarefas.fragments.InProgressFragment
import com.ctt.minhastarefas.fragments.ToDoFragment

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> ToDoFragment()
            1 -> InProgressFragment()
            2 -> DoneFragment()
            else -> ToDoFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "A fazer"
            1 -> "Em progresso"
            2 -> "Feitas"
            else -> super.getPageTitle(position)
        }
    }
}