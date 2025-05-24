package com.example.vwork.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.vwork.R
import com.example.vwork.fragments.DailyNotesFragment
import com.example.vwork.fragments.TechNotesFragment
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

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

        findViewById<View>(R.id.chatButton).setOnClickListener {
            // Replace with your actual chat activity
            // startActivity(Intent(this, ChatListActivity::class.java))
        }
    }
}
