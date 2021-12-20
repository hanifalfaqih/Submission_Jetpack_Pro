package com.allana.submissionsatu_jetpackpro.detail.movies

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesDetailEntity
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesDetailResponse
import com.allana.submissionsatu_jetpackpro.databinding.ActivityMoviesDetailBinding
import com.allana.submissionsatu_jetpackpro.databinding.DetailMoviesContentBinding
import com.allana.submissionsatu_jetpackpro.favorite.MoviesTvShowsFavoriteActivity
import com.allana.submissionsatu_jetpackpro.utils.ViewModelFactory
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlin.properties.Delegates

class MoviesDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIES_ID = "extra_movies_id"
        const val EXTRA_MOVIES_TITLE = "extra_movies_title"
    }

    private lateinit var activityMoviesDetailBinding: ActivityMoviesDetailBinding
    private lateinit var detailMoviesContentBinding: DetailMoviesContentBinding

    private lateinit var viewModel: MoviesDetailViewModel
    private lateinit var moviesTitle: String
    private var moviesId by Delegates.notNull<Int>()

    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMoviesDetailBinding = ActivityMoviesDetailBinding.inflate(layoutInflater)
        detailMoviesContentBinding = activityMoviesDetailBinding.detailMoviesContent

        setContentView(activityMoviesDetailBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        moviesTitle = intent.getStringExtra(EXTRA_MOVIES_TITLE).toString()
        supportActionBar?.title = moviesTitle

        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory)[MoviesDetailViewModel::class.java]

        moviesId = intent.getIntExtra(EXTRA_MOVIES_ID, 0)
        viewModel.getDetailMovie(moviesId).observe(this, { movieDetail ->
            showDetailMovie(movieDetail)
            addToFavorite(movieDetail)
        })

        viewModel.getDetailMovieFavorite(moviesId).observe(this, { movieDetailFavorite ->
            handleStateFavorite(movieDetailFavorite)
        })

        setStatusFavorite(isFavorite)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.detailToFavorite) {
            val intentToFavorite =
                Intent(this@MoviesDetailActivity, MoviesTvShowsFavoriteActivity::class.java)
            startActivity(intentToFavorite)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showDetailMovie(movies: List<MoviesDetailResponse>) {
        for (movie in movies) {
            Glide.with(this)
                .load(movie.poster)
                .into(activityMoviesDetailBinding.posterMovies)

            detailMoviesContentBinding.apply {
                tvMovieTitle.text = movie.title
                tvMovieDuration.text = movie.duration
                tvMovieRelease.text = movie.release
                tvMovieGenre.text = movie.genre
                tvMovieDirector.text = movie.director
                tvMovieScreenplay.text = movie.screenplay
                tvMovieBudget.text = movie.budget
                tvMovieRevenue.text = movie.revenue
                tvMovieOverview.text = movie.overview
                tvMovieCast.text = movie.cast
            }
        }
    }

    private fun addToFavorite(movies: List<MoviesDetailResponse>) {
        activityMoviesDetailBinding.favButtonMovie.setOnClickListener {
            isFavorite = !isFavorite
            viewModel.insertFromResponseToEntity(movies)
            if (isFavorite) {
                viewModel.insertMovie(viewModel.moviesEntity, viewModel.moviesDetailEntity)
                Snackbar.make(window.decorView.rootView, getString(R.string.text_add_success), Snackbar.LENGTH_SHORT).show()
            } else {
                viewModel.deleteMovie(viewModel.moviesEntity, viewModel.moviesDetailEntity)
                Snackbar.make(window.decorView.rootView, getString(R.string.text_delete_success), Snackbar.LENGTH_SHORT).show()
            }
            setStatusFavorite(isFavorite)
        }
    }

    private fun handleStateFavorite(movies: List<MoviesDetailEntity>) {
        for (movie in movies) {
            if (moviesId == movie.id) {
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
            activityMoviesDetailBinding.favButtonMovie.setImageDrawable(icon)
        } else {
            val icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border)
            activityMoviesDetailBinding.favButtonMovie.setImageDrawable(icon)
        }
    }
}