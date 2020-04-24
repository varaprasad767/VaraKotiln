package com.example.myassignment

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignment.MyAdapter.*

class MyAdapter(val context: Context,val list:MutableList<MyData>):
    RecyclerView.Adapter<RecyclerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.row_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.t.text=(list.get(position).title)
    }
    class RecyclerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)  {
        val t = itemView.findViewById<TextView>(R.id.rtext1)

    }

}