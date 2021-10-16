package com.spotify.ui.feature.main

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.spotify.R
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController)

        navView.setOnNavigationItemSelectedListener { item ->
            if(item.itemId != navView.selectedItemId)
                NavigationUI.onNavDestinationSelected(item, navController)
            true
        }

        init()
    }

    private fun init() {
        Handler(Looper.getMainLooper()).postDelayed({
            layoutMusicPlaying.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(this, R.anim.top_from_down)
            layoutMusicPlaying.startAnimation(animation)
        }, 2500)
    }
}