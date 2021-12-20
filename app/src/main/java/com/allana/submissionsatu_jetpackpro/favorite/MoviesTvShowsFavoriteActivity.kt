package com.allana.submissionsatu_jetpackpro.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.databinding.ActivityMoviesTvShowsFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator

class MoviesTvShowsFavoriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMoviesTvShowsFavoriteBinding = ActivityMoviesTvShowsFavoriteBinding.inflate(layoutInflater)
        setContentView(activityMoviesTvShowsFavoriteBinding.root)

        val sectionsPagerAdapter = SectionsPagerAdapterFavorite(this)
        activityMoviesTvShowsFavoriteBinding.viewPagerFavorite.adapter = sectionsPagerAdapter
        TabLayoutMediator(activityMoviesTvShowsFavoriteBinding.tabs,  activityMoviesTvShowsFavoriteBinding.viewPagerFavorite) { tab, position ->
            tab.text = resources.getString(sectionsPagerAdapter.tabTitles[position])
            tab.icon = ContextCompat.getDrawable(this, sectionsPagerAdapter.tabIcons[position])
        }.attach()

        supportActionBar?.elevation = 0f
        supportActionBar?.title = getString(R.string.title_menu_favorite)

    }

}