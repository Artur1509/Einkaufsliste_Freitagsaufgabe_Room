package com.example.einkaufsliste.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.einkaufsliste.data.datamodels.Artikel

@Dao
interface ArtikelDao {

    // Artikel abspeichern
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArtikel(artikel: Artikel)

    // Artikel löschen
    @Delete
    fun deleteArtikel(artikel: Artikel)

    //Alle Artikel wiedergeben
    @Query("SELECT * FROM artikel_table")
    fun getAllArtikel(): LiveData<List<Artikel>>

    //Anzahl der Artikel wiedergeben
    @Query("SELECT COUNT(*) FROM artikel_table")
    fun getArtikelCount(): Int
}