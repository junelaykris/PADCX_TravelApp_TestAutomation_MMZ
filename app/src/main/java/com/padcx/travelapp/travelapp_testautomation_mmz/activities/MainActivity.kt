package com.padcx.travelapp.travelapp_testautomation_mmz.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcx.travelapp.travelapp_testautomation_mmz.R
import com.padcx.travelapp.travelapp_testautomation_mmz.fragments.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swapFragment(HomeFragment.newInstance())

        swapFragment(HomeFragment.newInstance())

        bottomNavigation.setOnNavigationItemSelectedListener(object :
            BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.action_home -> {
                        swapFragment(HomeFragment.newInstance())
                        return true
                    }

                    R.id.action_star -> {
                        swapFragment(StaredFragment.newInstance())
                        return true
                    }
                    R.id.action_liked -> {
                        swapFragment(LikedFragment.newInstance())
                        return true
                    }
                    R.id.action_price -> {
                        swapFragment(PriceFragment.newInstance())
                        return true
                    }

                    R.id.action_search -> {
                        swapFragment(SearchFragment.newInstance())
                        return true
                    }
                }
                return false
            }

        })

    }


    private fun swapFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.flBottomNavigationContainer, fragment)
            .commit()

    }

}