package com.allana.submissionsatu_jetpackpro.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.movies.MoviesListFragment
import com.allana.submissionsatu_jetpackpro.tvshows.TvShowsListFragment

class SectionsPagerAdapterHome(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    val tabTitles = arrayOf(R.string.movies, R.string.tv_shows)
    val tabIcons = arrayOf(R.drawable.ic_baseline_local_movies, R.drawable.ic_baseline_tv)

    override fun getItemCount(): Int = tabTitles.size

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> MoviesListFragment()
            1 -> TvShowsListFragment()
            else -> Fragment()
        }


}