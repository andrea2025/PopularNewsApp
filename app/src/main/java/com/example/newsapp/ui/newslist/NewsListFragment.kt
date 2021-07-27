package com.example.newsapp.ui.newslist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.model.RetrofitService
import com.example.newsapp.databinding.FragmentNewsListBinding
import kotlinx.coroutines.*

class NewsListFragment : Fragment(){
    lateinit var newsAdapter:NewsListAdapter
    lateinit var recyclerView: RecyclerView
    val service = RetrofitService.apiClient
    companion object{
        fun instance() = NewsListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentNewsListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_news_list, container, false)

        recyclerView = binding.recyclerNewsList
        recyclerView.layoutManager= LinearLayoutManager(context)

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getViewed()
            withContext(Dispatchers.Main) {
                try {

                    // Check if response was successful.
                    if (response.isSuccessful && response.body() != null) {
                        val data = response.body()!!
                        Log.i("kk", data.toString())

                        recyclerView.adapter = NewsListAdapter(response)
                    } else {
                        // Show API error.
                        Toast.makeText(
                            context,
                            "Error Occurred: ${response.raw()}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                } catch (e: Exception) {
                    // Show API error. This is the error raised by the client.
                    Toast.makeText(
                        context,
                        "Error Occurred: ${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

        return binding.root
    }



}