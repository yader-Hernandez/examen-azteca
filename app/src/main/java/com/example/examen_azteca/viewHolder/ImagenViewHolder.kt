package com.example.examen_azteca.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.examen_azteca.databinding.ItemImagenBinding
import com.squareup.picasso.Picasso

class ImagenViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemImagenBinding.bind(view)
    fun bind(imagen: String){
        Picasso.get().load(imagen).into( binding.imageView)
    }
}