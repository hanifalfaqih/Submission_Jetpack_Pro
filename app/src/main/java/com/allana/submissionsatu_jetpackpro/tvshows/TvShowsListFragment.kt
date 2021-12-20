package com.allana.submissionsatu_jetpackpro.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.allana.submissionsatu_jetpackpro.databinding.FragmentTvShowsListBinding
import com.allana.submissionsatu_jetpackpro.utils.ViewModelFactory


class TvShowsListFragment : Fragment() {

    private lateinit var fragmentTvShowsBinding: FragmentTvShowsListBinding
    private lateinit var tvShowsAdapter: TvShowsAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        fragmentTvShowsBinding = FragmentTvShowsListBinding.inflate(inflater, container, false)
        return fragmentTvShowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            val viewModelTvShows = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]

            tvShowsAdapter = TvShowsAdapter()

            viewModelTvShows.getAllTvShows().observe(viewLifecycleOwner, { listTvShows ->
                tvShowsAdapter.setTvShows(listTvShows)
                tvShowsAdapter.notifyDataSetChanged()

                if (listTvShows.isNullOrEmpty()) {
                    stateDataEmpty()
                } else {
                    stateDataNotEmpty()
                }
            })
        }
    }

    private fun stateDataEmpty() {
        fragmentTvShowsBinding.rvTvshows.visibility = View.GONE
        fragmentTvShowsBinding.tvEmpty.visibility = View.VISIBLE
    }

    private fun stateDataNotEmpty() {
        with(fragmentTvShowsBinding.rvTvshows) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tvShowsAdapter
        }
    }
}