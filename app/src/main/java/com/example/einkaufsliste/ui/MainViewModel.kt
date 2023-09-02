package com.example.einkaufsliste.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.einkaufsliste.data.local.ArtikelDatabase.Companion.getDatabase
import com.example.einkaufsliste.data.local.Repository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // Zugriff auf Repository & Db
    private val database = getDatabase(application)
    private val repository = Repository(database)

    val artikelListe = repository.artikelListe

    init {
        viewModelScope.launch{
            repository.prepopulateDB()
            Log.d("ViewModel", "Datenbank befüllt")
        }
    }



}