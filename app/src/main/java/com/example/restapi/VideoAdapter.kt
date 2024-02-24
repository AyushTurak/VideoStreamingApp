package com.example.restapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(private val dataList : ArrayList<String>) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
 val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rvitem,parent,false)
        return ViewHolder(itemView)    }

    override fun getItemCount(): Int {
         return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val currentItem = dataList[position]
        holder.title.text = currentItem
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val title : TextView = itemView.findViewById(R.id.title)
    }

}