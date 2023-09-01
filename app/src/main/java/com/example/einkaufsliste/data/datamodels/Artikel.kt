package com.example.einkaufsliste.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artikel_table")
data class Artikel(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val menge: Int

)
