package com.allana.submissionsatu_jetpackpro.movies.favorite

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
import com.allana.submissionsatu_jetpackpro.databinding.FragmentMoviesListFavoriteBinding
import com.allana.submissionsatu_jetpackpro.movies.MoviesViewModel
import com.allana.submissionsatu_jetpackpro.utils.ViewModelFactory
import com.google.android.material.snackbar.Snackbar


class MoviesListFavoriteFragment : Fragment() {

    private lateinit var fragmentMoviesListFavoriteBinding: FragmentMoviesListFavoriteBinding
    private lateinit var moviesFavoriteAdapter: MoviesFavoriteAdapter

    private lateinit var viewModelMoviesFavorite: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesListFavoriteBinding = FragmentMoviesListFavoriteBinding.inflate(inflater, container, false)
        return fragmentMoviesListFavoriteBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentMoviesListFavoriteBinding.rvMoviesFav)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModelMoviesFavorite = ViewModelProvider(
                this,
                factory
            )[MoviesViewModel::class.java]

            moviesFavoriteAdapter = MoviesFavoriteAdapter()

            viewModelMoviesFavorite.getAllMoviesFavorite().observe(viewLifecycleOwner, { listMovies ->
                moviesFavoriteAdapter.submitList(listMovies)

                if (listMovies.isNullOrEmpty()) {
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
                val tvShowEntity = moviesFavoriteAdapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { viewModelMoviesFavorite.deleteMovie(viewModelMoviesFavorite.moviesEntity, viewModelMoviesFavorite.moviesDetailEntity)}

                val snackbar = Snackbar.make(view as View, R.string.text_delete_success, Snackbar.LENGTH_SHORT)
                snackbar.show()
            }
        }

    })

    private fun stateDataEmpty() {
        fragmentMoviesListFavoriteBinding.rvMoviesFav.visibility = View.GONE
        fragmentMoviesListFavoriteBinding.tvEmpty.visibility = View.VISIBLE
    }

    private fun stateDataNotEmpty() {
        with(fragmentMoviesListFavoriteBinding.rvMoviesFav) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = moviesFavoriteAdapter
        }
    }
}