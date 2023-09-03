package com.example.einkaufsliste.util

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.einkaufsliste.data.datamodels.Artikel
import com.example.einkaufsliste.data.local.ArtikelDatabase
import com.example.einkaufsliste.databinding.ListItemBinding
import com.example.einkaufsliste.ui.MainViewModel
import kotlin.coroutines.coroutineContext

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

        // Artikel aus DB löschen
        holder.binding.deleteBTN.setOnClickListener {
            MainViewModel(application = Application()).deleteArtikel(item)
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}