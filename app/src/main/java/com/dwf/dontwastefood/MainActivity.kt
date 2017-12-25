package com.dwf.dontwastefood

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val transaction = fragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navigation_home -> {
                transaction
                        .replace(fragment_container.id, HomeFragment.newInstance("", ""))
                        .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                        .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recipe -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_favorite -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fragmentManager.beginTransaction()
                .replace(fragment_container.id, HomeFragment.newInstance("", ""))
                .setTransition(FragmentTransaction.TRANSIT_ENTER_MASK)
                .commit()
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
