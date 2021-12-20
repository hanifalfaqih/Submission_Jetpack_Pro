package com.allana.submissionsatu_jetpackpro.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.databinding.ActivityHomeBinding
import com.allana.submissionsatu_jetpackpro.favorite.MoviesTvShowsFavoriteActivity
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapterHome(this)
        activityHomeBinding.viewPagerHome.adapter = sectionsPagerAdapter
        TabLayoutMediator(activityHomeBinding.tabs, activityHomeBinding.viewPagerHome) { tab, position ->
            tab.text = resources.getString(sectionsPagerAdapter.tabTitles[position])
            tab.icon = ContextCompat.getDrawable(this, sectionsPagerAdapter.tabIcons[position])
        }.attach()

        supportActionBar?.elevation = 0f
        supportActionBar?.title = getString(R.string.tv_title_app)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.homeToFavorite) {
            val intentToFavorite = Intent(this@HomeActivity, MoviesTvShowsFavoriteActivity::class.java)
            startActivity(intentToFavorite)
        }
        return super.onOptionsItemSelected(item)
    }
}