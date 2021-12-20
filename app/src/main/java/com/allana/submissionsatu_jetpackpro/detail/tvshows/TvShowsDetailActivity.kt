package com.allana.submissionsatu_jetpackpro.detail.tvshows

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsDetailEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsDetailResponse
import com.allana.submissionsatu_jetpackpro.databinding.ActivityTvShowsDetailBinding
import com.allana.submissionsatu_jetpackpro.databinding.DetailTvShowsContentBinding
import com.allana.submissionsatu_jetpackpro.favorite.MoviesTvShowsFavoriteActivity
import com.allana.submissionsatu_jetpackpro.utils.ViewModelFactory
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.Delegates

class TvShowsDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOWS_ID = "extra_tv_shows_id"
        const val EXTRA_TV_SHOWS_TITLE = "extra_tv_shows_title"
    }

    private lateinit var activityTvShowsDetailBinding: ActivityTvShowsDetailBinding
    private lateinit var detailTvShowsContentBinding: DetailTvShowsContentBinding

    private lateinit var viewModel: TvShowsDetailViewModel
    private lateinit var tvShowsTitle: String
    private var tvShowsId by Delegates.notNull<Int>()

    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityTvShowsDetailBinding = ActivityTvShowsDetailBinding.inflate(layoutInflater)
        detailTvShowsContentBinding = activityTvShowsDetailBinding.detailTvShowsContent

        setContentView(activityTvShowsDetailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        tvShowsId = intent.getIntExtra(EXTRA_TV_SHOWS_ID, 0)

        tvShowsTitle = intent.getStringExtra(EXTRA_TV_SHOWS_TITLE).toString()
        supportActionBar?.title = tvShowsTitle

        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory)[TvShowsDetailViewModel::class.java]

        viewModel.getDetailTvShow(tvShowsId).observe(this, { tvShowDetail ->
            showDetailTvShows(tvShowDetail)
            addToFavorite(tvShowDetail)
        })
        viewModel.getDetailTvShowFavorite(tvShowsId).observe(this, { tvShowDetailFavorite ->
            handleStateFavorite(tvShowDetailFavorite)
        })

        setStatusFavorite(isFavorite)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.detailToFavorite) {
            val intentToFavorite = Intent(this@TvShowsDetailActivity, MoviesTvShowsFavoriteActivity::class.java)
            startActivity(intentToFavorite)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDetailTvShows(tvShows: List<TvShowsDetailResponse>) {
        for (tvShow in tvShows) {
            Glide.with(this)
                .load(tvShow.poster)
                .into(activityTvShowsDetailBinding.posterTvShows)

            detailTvShowsContentBinding.apply {
                tvTvshowTitle.text = tvShow.title
                tvTvshowRelease.text = tvShow.release
                tvTvshowDuration.text = tvShow.duration
                tvTvshowGenre.text = tvShow.genre
                tvTvshowCreator.text = tvShow.creator
                tvTvshowOverview.text = tvShow.overview
                tvTvshowCast.text = tvShow.cast
            }
        }
    }

    private fun addToFavorite(tvShows: List<TvShowsDetailResponse>) {
        activityTvShowsDetailBinding.favButtonTvShow.setOnClickListener {
            isFavorite = !isFavorite
            viewModel.insertFromResponseToEntity(tvShows)
            if (isFavorite) {
                viewModel.insertTvShow(viewModel.tvShowsEntity, viewModel.tvShowsDetailEntity)
                Snackbar.make(window.decorView.rootView, getString(R.string.text_add_success), Snackbar.LENGTH_SHORT).show()
            } else {
                viewModel.deleteTvShow(viewModel.tvShowsEntity, viewModel.tvShowsDetailEntity)
                Snackbar.make(window.decorView.rootView, getString(R.string.text_delete_success), Snackbar.LENGTH_SHORT).show()
            }
            setStatusFavorite(isFavorite)
        }

    }

    private fun handleStateFavorite(tvShows: List<TvShowsDetailEntity>) {
        for (tvShow in tvShows) {
            if (tvShowsId == tvShow.id) {
                isFavorite = true
                setStatusFavorite(isFavorite)
            } else {
                isFavorite = false
                setStatusFavorite(isFavorite)
            }
        }
    }

    private fun setStatusFavorite(state: Boolean) {
        if (state) {
            val icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite)
            activityTvShowsDetailBinding.favButtonTvShow.setImageDrawable(icon)
        } else {
            val icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border)
            activityTvShowsDetailBinding.favButtonTvShow.setImageDrawable(icon)
        }
    }
}