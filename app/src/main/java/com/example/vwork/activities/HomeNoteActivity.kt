package com.example.vwork.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.vwork.R
import com.example.vwork.fragments.DailyNotesFragment
import com.example.vwork.fragments.TechNotesFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class HomeNoteActivity : AppCompatActivity() {

    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_note)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val mainFab: FloatingActionButton = findViewById(R.id.mainFab)
        val techFab: FloatingActionButton = findViewById(R.id.techFab)
        val dailyFab: FloatingActionButton = findViewById(R.id.dailyFab)


        viewPager.adapter = object : FragmentPagerAdapter(
            supportFragmentManager,
            BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        ) {
            override fun getItem(position: Int): Fragment {
                return if (position == 0) TechNotesFragment() else DailyNotesFragment()
            }

            override fun getCount(): Int = 2

            override fun getPageTitle(position: Int): CharSequence {
                return if (position == 0) "Tech Notes" else "Daily Notes"
            }
        }

        tabLayout.setupWithViewPager(viewPager)


        mainFab.setOnClickListener {
            if (!isFabOpen) {
                techFab.visibility = View.VISIBLE
                dailyFab.visibility = View.VISIBLE
                isFabOpen = true
            } else {
                techFab.visibility = View.GONE
                dailyFab.visibility = View.GONE
                isFabOpen = false
            }
        }

        techFab.setOnClickListener {
            // handle tech note action
        }

        dailyFab.setOnClickListener {
            // handle daily note action
        }
    }
}