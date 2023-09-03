package com.example.einkaufsliste.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.einkaufsliste.data.datamodels.Artikel
import com.example.einkaufsliste.databinding.ListItemBinding
import com.example.einkaufsliste.ui.MainViewModel

class ArtikelAdapter(
    var dataset: List<Artikel>,

): RecyclerView.Adapter<ArtikelAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.binding.artikelTV.text = item.name

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}