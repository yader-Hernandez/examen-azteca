package com.example.examen_azteca.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_azteca.R
import com.example.examen_azteca.viewHolder.ImagenViewHolder

class ImageAdapter(val images: List<String>):RecyclerView.Adapter<ImagenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagenViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ImagenViewHolder(layoutInflater.inflate(R.layout.item_imagen, parent,false))
    }

    override fun onBindViewHolder(holder: ImagenViewHolder, position: Int) {
        val item: String = images[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = images.size
}