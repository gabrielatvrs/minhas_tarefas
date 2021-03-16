package com.ctt.minhastarefas.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.viewpager.widget.ViewPager
import com.ctt.minhastarefas.R
import com.ctt.minhastarefas.adapters.PageAdapter
import com.ctt.minhastarefas.fragments.NewTaskFragment
import com.google.android.material.tabs.TabLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var btnAbrirMenuNovaTarefa: Button
    private lateinit var edtPesquisar: EditText
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        val newTaskFragment = NewTaskFragment()

        btnAbrirMenuNovaTarefa = findViewById(R.id.btnAbrirMenuNovaTarefa)

        btnAbrirMenuNovaTarefa.setOnClickListener {
            newTaskFragment.show(supportFragmentManager, "TAG")
        }

        edtPesquisar = findViewById(R.id.barraPesquisar)

        edtPesquisar.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {

                if (event.action == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER
                ) {
                    Toast.makeText(this@MainActivity, edtPesquisar.text, Toast.LENGTH_SHORT).show()
                    escondeTeclado()
                    return true
                }
                return false
            }
        })

        escondeBotao()
    }

    fun escondeBotao() {
        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    btnAbrirMenuNovaTarefa.visibility = View.VISIBLE
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    btnAbrirMenuNovaTarefa.visibility = View.GONE
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                if (tab?.position == 0) {
                    btnAbrirMenuNovaTarefa.visibility = View.VISIBLE
                }
            }
        })
    }

    fun escondeTeclado() {
        (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).apply {
            hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}