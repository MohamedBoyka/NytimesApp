package com.boyka.nytimesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.boyka.nytimesapp.R
import com.boyka.nytimesapp.adapter.NewsAdapter
import com.boyka.nytimesapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* adapter = NewsAdapter()
        val prog: ProgressBar =findViewById(R.id.progress)
        val rvNews: RecyclerView =findViewById(R.id.rvNews)
        val rootView: ConstraintLayout =findViewById(R.id.rootView)

        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = adapter

        mainViewModel.res.observe(this, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    prog.visibility = View.GONE
                    rvNews.visibility = View.VISIBLE
                    it.data.let {res->
                        if (res?.status == "OK"){
                            res.results?.let { it1 -> adapter.submitList(it1) }

                        }else{

                            Snackbar.make(rootView, "Status = false", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                Status.LOADING -> {
                    prog.visibility = View.VISIBLE
                    rvNews.visibility = View.GONE
                }
                Status.ERROR -> {
                    prog.visibility = View.GONE
                    rvNews.visibility = View.VISIBLE
                    Snackbar.make(rootView, "Something went wrong", Snackbar.LENGTH_SHORT).show()
                }
            }
        })*/
    }
}