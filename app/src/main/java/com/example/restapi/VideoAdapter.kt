package com.example.restapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(val context: Context,val dataList : ArrayList<data>) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
 val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rvitem,parent,false)
        return ViewHolder(itemView)    }

    override fun getItemCount(): Int {
         return dataList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
     val currentItem = dataList[position]
        holder.title.text = currentItem.title

    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val title : TextView = itemView.findViewById(R.id.title)
        val img : ImageView = itemView.findViewById(R.id.image)
    }

//
//    fun refreshData(dataList: ArrayList<data>){
//        dataList =
//        notifyDataSetChanged()
//    }
}