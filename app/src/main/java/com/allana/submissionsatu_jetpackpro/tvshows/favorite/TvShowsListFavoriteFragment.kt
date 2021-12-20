package com.allana.submissionsatu_jetpackpro.tvshows.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.allana.submissionsatu_jetpackpro.R
import com.allana.submissionsatu_jetpackpro.databinding.FragmentTvShowsListFavoriteBinding
import com.allana.submissionsatu_jetpackpro.tvshows.TvShowsViewModel
import com.allana.submissionsatu_jetpackpro.utils.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class TvShowsListFavoriteFragment : Fragment() {

    private lateinit var fragmentTvShowsListFavoriteBinding : FragmentTvShowsListFavoriteBinding
    private lateinit var tvShowsFavoriteAdapter: TvShowsFavoriteAdapter

    private lateinit var viewModelTvShowsFavorite: TvShowsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowsListFavoriteBinding = FragmentTvShowsListFavoriteBinding.inflate(inflater, container, false)
        return fragmentTvShowsListFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentTvShowsListFavoriteBinding.rvTvshowsFav)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModelTvShowsFavorite = ViewModelProvider(
                this,
                factory
            )[TvShowsViewModel::class.java]

            tvShowsFavoriteAdapter = TvShowsFavoriteAdapter()

            viewModelTvShowsFavorite.getAllTvShowsFavorite().observe(viewLifecycleOwner, { listTvShows ->
                tvShowsFavoriteAdapter.submitList(listTvShows)

                if (listTvShows.isNullOrEmpty()) {
                    stateDataEmpty()
                } else {
                    stateDataNotEmpty()
                }
            })
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object :  ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean =
            true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.absoluteAdapterPosition
                val tvShowEntity = tvShowsFavoriteAdapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { viewModelTvShowsFavorite.deleteTvShow(viewModelTvShowsFavorite.tvShowsEntity, viewModelTvShowsFavorite.tvShowsDetailEntity)}

                val snackbar = Snackbar.make(view as View, R.string.text_delete_success, Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
        }

    })

    private fun stateDataEmpty() {
        fragmentTvShowsListFavoriteBinding.rvTvshowsFav.visibility = View.GONE
        fragmentTvShowsListFavoriteBinding.tvEmpty.visibility = View.VISIBLE
    }

    private fun stateDataNotEmpty() {
        with(fragmentTvShowsListFavoriteBinding.rvTvshowsFav) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvShowsFavoriteAdapter
        }
    }
}