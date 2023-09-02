package com.example.einkaufsliste.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.einkaufsliste.data.datamodels.Artikel

@Database(entities = [Artikel::class], version = 1)
abstract class ArtikelDatabase: RoomDatabase() {

    abstract val artikelDao: ArtikelDao

    companion object {

        private lateinit var INSTANCE: ArtikelDatabase

        fun getDatabase(context: Context): ArtikelDatabase {
            synchronized(ArtikelDatabase::class.java){
                if(!::INSTANCE.isInitialized){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        ArtikelDatabase::class.java,
                        "artikel_database"
                    ).allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }

}