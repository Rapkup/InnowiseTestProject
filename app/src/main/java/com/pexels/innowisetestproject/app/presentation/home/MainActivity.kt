package com.pexels.innowisetestproject.app.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.pexels.innowisetestproject.R

class MainActivity : AppCompatActivity() {
   /* private lateinit var binding: ActivityMainBinding*/

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Base_Theme_InnowiseTestProject)
        super.onCreate(savedInstanceState)

      /*  binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)*/

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        setBackPressed(navController)

        initBottomNavView(navController)
    }

    private fun setBackPressed(navController: NavController) {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navController.popBackStack()
            }
        })
    }

    private fun initBottomNavView(navController: NavController) {
       /* binding.navView.apply {
            itemIconTintList = null
            itemActiveIndicatorColor = null

            setOnItemSelectedListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.navigation_home -> {
                        navController.navigate(R.id.homeFragment)
                    }

                    R.id.navigation_bookmarks -> {
                        navController.navigate(R.id.bookmarksFragment)
                    }
                }
                true
            }
        }*/
    }
}