package com.allana.submissionsatu_jetpackpro.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.allana.submissionsatu_jetpackpro.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activitySplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(activitySplashScreenBinding.root)

        activitySplashScreenBinding.tvTitleSplashsreen.alpha = 0f
        activitySplashScreenBinding.logoTmdbSplashscreen.alpha = 0f

        activitySplashScreenBinding.tvTitleSplashsreen.animate().setDuration(2000).alpha(1f).withEndAction {
            val moveToHomeActivity = Intent(this, HomeActivity::class.java)
            startActivity(moveToHomeActivity)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
        activitySplashScreenBinding.logoTmdbSplashscreen.animate().setDuration(2000).alpha(1f).withEndAction {
            val moveToHomeActivity = Intent(this, HomeActivity::class.java)
            startActivity(moveToHomeActivity)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}