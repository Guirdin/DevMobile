package com.muller.minijeux


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_icon.view.*

class ListAdapter(private val listItems : List<Items>) : RecyclerView.Adapter<ListAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_icon, parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentItem = listItems[position]
        holder.imageView.setBackgroundResource(currentItem.imageResource)
        holder.textView1.setText(currentItem.name)
    }

    override fun getItemCount() = listItems.size

    class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: Button = itemView.image_view
        val textView1: TextView = itemView.text_view_1
    }
}