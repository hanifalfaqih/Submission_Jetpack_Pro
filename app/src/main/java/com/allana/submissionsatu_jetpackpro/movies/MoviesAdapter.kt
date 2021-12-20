package com.allana.submissionsatu_jetpackpro.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allana.submissionsatu_jetpackpro.data.remote.responses.MoviesResponse
import com.allana.submissionsatu_jetpackpro.databinding.ItemsMoviesBinding
import com.allana.submissionsatu_jetpackpro.detail.movies.MoviesDetailActivity
import com.bumptech.glide.Glide

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var listMovies = ArrayList<MoviesResponse>()

    fun setMovies(movies: List<MoviesResponse>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MoviesViewHolder {
        val itemsMoviesBinding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MoviesViewHolder(private val binding: ItemsMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: MoviesResponse) {
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
}