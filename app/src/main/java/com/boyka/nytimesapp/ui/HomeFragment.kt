package com.boyka.nytimesapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.boyka.nytimesapp.adapter.NewsAdapter
import com.boyka.nytimesapp.databinding.FragmentHomeBinding
import com.boyka.nytimesapp.utils.Status
import com.boyka.nytimesapp.viewModel.MainViewModel
import com.google.android.material.snackbar.Snackbar
import com.boyka.domain.model.Result


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding

    private lateinit var adapter: NewsAdapter
    private val mainViewModel by activityViewModels<MainViewModel>()

    val navController : NavController by lazy {
        findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater , container , false)
        binding.lifecycleOwner =this

        setupAndGetData()
        click()

        return binding.root

    }


    private fun setupAndGetData(){

        adapter = NewsAdapter()

        binding.rvNews.layoutManager = LinearLayoutManager(context)
        binding.rvNews.adapter = adapter

        mainViewModel.res.observe(viewLifecycleOwner, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    binding.progress.visibility = View.GONE
                    binding.rvNews.visibility = View.VISIBLE
                    it.data.let {res->
                        if (res?.status == "OK"){
                            res.results?.let { it1 -> adapter.submitList(it1) }

                        }else{

                            Snackbar.make(binding.rootView, "Status = false", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                Status.LOADING -> {
                    binding.progress.visibility = View.VISIBLE
                    binding.rvNews.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progress.visibility = View.GONE
                    binding.rvNews.visibility = View.VISIBLE
                    Snackbar.make(binding.rootView, "Something went wrong", Snackbar.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun click(){

            adapter.setOnClickListener(object :
            NewsAdapter.OnClickListener {
            override fun onClick(position: Int, model: Result) {

                navController.navigate(HomeFragmentDirections.actionHomeFragmentToDetailsragment( model.nytdsection,
                model.abstract ,
                model.adx_keywords))
            }
        })
    }


    }

