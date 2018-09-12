package com.example.redhelicopter07.myapplication

import android.support.v4.app.Fragment
import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.R.attr.fragment



class MainActivity : AppCompatActivity() {
    private lateinit var mDrawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDrawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            var fragment: Fragment? = null
            val fragmentClass: Class<*>
            when (menuItem.itemId) {
                R.id.fragment1 -> fragmentClass = fragment1::class.java
                R.id.fragment2 -> fragmentClass = fragment1::class.java
                R.id.fragment3 -> fragmentClass = fragment1::class.java
                else -> fragmentClass = fragment1::class.java
            }

            try {
                fragment = fragmentClass.newInstance() as Fragment
            } catch (e: Exception) {
                e.printStackTrace()
            }


            // Insert the fragment by replacing any existing fragment
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }
    }
}
