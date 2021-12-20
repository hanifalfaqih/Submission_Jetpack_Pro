package com.allana.submissionsatu_jetpackpro.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.allana.submissionsatu_jetpackpro.databinding.FragmentMoviesListBinding
import com.allana.submissionsatu_jetpackpro.utils.ViewModelFactory


class MoviesListFragment : Fragment() {

    private lateinit var fragmentMoviesListBinding: FragmentMoviesListBinding
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentMoviesListBinding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return fragmentMoviesListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModelMovies = ViewModelProvider(
                    this,
                    factory
            )[MoviesViewModel::class.java]

            moviesAdapter = MoviesAdapter()

            viewModelMovies.getAllMovies().observe(viewLifecycleOwner, { listMovies ->
                moviesAdapter.setMovies(listMovies)
                moviesAdapter.notifyDataSetChanged()

                if (listMovies.isNullOrEmpty()) {
                    stateDataEmpty()
                } else {
                    stateDataNotEmpty()
                }
            })
        }
    }

    private fun stateDataEmpty() {
        fragmentMoviesListBinding.rvMovies.visibility = View.GONE
        fragmentMoviesListBinding.tvEmpty.visibility = View.VISIBLE
    }

    private fun stateDataNotEmpty() {
        with(fragmentMoviesListBinding.rvMovies) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }
    }
}