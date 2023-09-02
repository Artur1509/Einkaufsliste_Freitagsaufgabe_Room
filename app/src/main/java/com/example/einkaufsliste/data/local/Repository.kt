package com.example.einkaufsliste.data.local

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.einkaufsliste.data.datamodels.Artikel
import com.example.einkaufsliste.data.example.ArtikelExample

class Repository(private val database: ArtikelDatabase) {

    val artikelListe: LiveData<List<Artikel>> = database.artikelDao.getAllArtikel()

    // Neuen Artikel in DB einfügen
    suspend fun insertArtikel(artikel: Artikel){
        try {
            database.artikelDao.insertArtikel(artikel)
        }catch (e: Exception){
            Log.e("Repository", "Error beim einfügen eines neuen Artikels")
        }
    }

    //Alle Artikel anzeigen
    fun getAllArtikel(): LiveData<List<Artikel>> {
        return database.artikelDao.getAllArtikel()
    }

    // Artikel löschen
    fun deleteArtikel(artikel: Artikel) {
        database.artikelDao.deleteArtikel(artikel)
    }

    //Artikel count
    fun countArtikel(): Int {
        return database.artikelDao.getArtikelCount()
    }

    suspend fun prepopulateDB(){
        database.artikelDao.insertArtikel(ArtikelExample.artikel1)
    }

}