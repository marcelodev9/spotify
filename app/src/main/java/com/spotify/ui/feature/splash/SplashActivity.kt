package com.spotify.ui.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.spotify.R
import com.spotify.ui.feature.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        waitingAndGo()
    }

    private fun waitingAndGo() {
        Handler(Looper.getMainLooper()).postDelayed({
            goToMainActivity()
        }, 1500)
    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        this.finish()
    }
}