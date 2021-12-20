package com.allana.submissionsatu_jetpackpro.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allana.submissionsatu_jetpackpro.data.remote.responses.TvShowsResponse
import com.allana.submissionsatu_jetpackpro.databinding.ItemsTvShowsBinding
import com.allana.submissionsatu_jetpackpro.detail.tvshows.TvShowsDetailActivity
import com.bumptech.glide.Glide

class TvShowsAdapter : RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {

    private val listTvShows = ArrayList<TvShowsResponse>()

    fun setTvShows(tvShows: List<TvShowsResponse>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsAdapter.TvShowsViewHolder {
        val itemsTvShowsBinding = ItemsTvShowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsTvShowsBinding)
    }

    override fun onBindViewHolder(holder: TvShowsAdapter.TvShowsViewHolder, position: Int) {
        val tvShows = listTvShows[position]
        holder.bind(tvShows)
    }

    override fun getItemCount(): Int = listTvShows.size

    inner class TvShowsViewHolder(private val binding: ItemsTvShowsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowsResponse) {
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

}