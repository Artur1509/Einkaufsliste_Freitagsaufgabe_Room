package com.example.einkaufsliste.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.einkaufsliste.data.datamodels.Artikel
import com.example.einkaufsliste.data.local.ArtikelDatabase.Companion.getDatabase
import com.example.einkaufsliste.data.local.Repository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // Zugriff auf Repository & Db
    private val database = getDatabase(application)
    private val repository = Repository(database)

    val artikelListe: LiveData<List<Artikel>> = repository.getAllArtikel()

    //Artikel löschen

    fun deleteArtikel(artikel: Artikel){
        repository.deleteArtikel(artikel)
    }

    //delete by id
    fun deleteById(id: Int){
        repository.deleteById(id)
    }

    // neuen Artikel einfügen
    fun addArtikel(artikel: Artikel){
        viewModelScope.launch{
            repository.insertArtikel(artikel)
        }
    }


}