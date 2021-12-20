package com.allana.submissionsatu_jetpackpro.movies.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.allana.submissionsatu_jetpackpro.data.local.entity.MoviesEntity
import com.allana.submissionsatu_jetpackpro.databinding.ItemsMoviesBinding
import com.allana.submissionsatu_jetpackpro.detail.movies.MoviesDetailActivity
import com.bumptech.glide.Glide

class MoviesFavoriteAdapter: PagedListAdapter<MoviesEntity, MoviesFavoriteAdapter.MoviesFavoriteViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object: DiffUtil.ItemCallback<MoviesEntity>() {
            override fun areItemsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MoviesEntity, newItem: MoviesEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesFavoriteAdapter.MoviesFavoriteViewHolder {
        val itemsMoviesBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesFavoriteViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesFavoriteAdapter.MoviesFavoriteViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

    inner class MoviesFavoriteViewHolder(private val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesEntity) {
            with(binding) {
                tvMovieTitle.text = movies.title
                tvMovieRelease.text = movies.release
                tvMovieGenre.text = movies.genre
                itemView.setOnClickListener {
                    val intentToMoviesDetail = Intent(itemView.context, MoviesDetailActivity::class.java)
                    intentToMoviesDetail.putExtra(MoviesDetailActivity.EXTRA_MOVIES_ID, movies.id)
                    intentToMoviesDetail.putExtra(MoviesDetailActivity.EXTRA_MOVIES_TITLE, movies.title)
                    itemView.context.startActivity(intentToMoviesDetail)
                }
                Glide.with(itemView.context)
                    .load(movies.poster)
                    .into(posterMovies)
            }
        }
    }

    fun getSwipedData(swipedPosition: Int): MoviesEntity? = getItem(swipedPosition)
}