package com.ctt.minhastarefas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.adapters.PageAdapter
import com.ctt.minhastarefas.fragments.NewTaskFragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var btnAbrirMenuNovaTarefa: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        btnAbrirMenuNovaTarefa = findViewById(R.id.btnAbrirMenuNovaTarefa)

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        val newTaskFragment = NewTaskFragment()

        btnAbrirMenuNovaTarefa.setOnClickListener {
            newTaskFragment.show(supportFragmentManager, "TAG")
        }
    }
}