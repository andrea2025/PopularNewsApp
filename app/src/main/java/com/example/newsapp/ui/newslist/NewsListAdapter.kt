package com.example.newsapp.ui.newslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import retrofit2.Response

class NewsListAdapter(private val list: Response<List<NewsList>>) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleText: TextView
        val descriptionText: TextView

        init {
            titleText = view.findViewById(R.id.title)
            descriptionText = view.findViewById(R.id.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsListAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = list.body()?.size!!

}