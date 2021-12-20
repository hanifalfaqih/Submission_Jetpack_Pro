package com.allana.submissionsatu_jetpackpro.favorite

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.movies.favorite.MoviesListFavoriteFragment
import com.allana.submissionsatu_jetpackpro.tvshows.favorite.TvShowsListFavoriteFragment

class SectionsPagerAdapterFavorite(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    val tabTitles = intArrayOf(R.string.movies, R.string.tv_shows)
    val tabIcons = arrayOf(R.drawable.ic_baseline_local_movies, R.drawable.ic_baseline_tv)

    override fun getItemCount(): Int = tabTitles.size

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> MoviesListFavoriteFragment()
            1 -> TvShowsListFavoriteFragment()
            else -> Fragment()

        }
}