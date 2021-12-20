package com.allana.submissionsatu_jetpackpro.tvshows.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.allana.submissionsatu_jetpackpro.data.local.entity.TvShowsEntity
import com.allana.submissionsatu_jetpackpro.databinding.ItemsTvShowsBinding
import com.allana.submissionsatu_jetpackpro.detail.tvshows.TvShowsDetailActivity
import com.bumptech.glide.Glide

class TvShowsFavoriteAdapter: PagedListAdapter<TvShowsEntity, TvShowsFavoriteAdapter.TvShowsFavoriteViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowsEntity>() {
            override fun areItemsTheSame(oldItem: TvShowsEntity, newItem: TvShowsEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowsEntity, newItem: TvShowsEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsFavoriteAdapter.TvShowsFavoriteViewHolder {
        val itemsTvShowsBinding = ItemsTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsFavoriteViewHolder(itemsTvShowsBinding)
    }

    override fun onBindViewHolder(holder: TvShowsFavoriteAdapter.TvShowsFavoriteViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    inner class TvShowsFavoriteViewHolder(private val binding: ItemsTvShowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowsEntity) {
            with(binding) {
                tvTvshowTitle.text = tvShows.title
                tvTvshowRelease.text = tvShows.release
                tvTvshowGenre.text = tvShows.genre
                itemView.setOnClickListener {
                    val intentToTvShows = Intent(itemView.context, TvShowsDetailActivity::class.java)
                    intentToTvShows.putExtra(TvShowsDetailActivity.EXTRA_TV_SHOWS_ID, tvShows.id)
                    intentToTvShows.putExtra(TvShowsDetailActivity.EXTRA_TV_SHOWS_TITLE, tvShows.title)
                    itemView.context.startActivity(intentToTvShows)
                }
                Glide.with(itemView.context)
                    .load(tvShows.poster)
                    .into(posterTvShows)
            }
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowsEntity? = getItem(swipedPosition)

}