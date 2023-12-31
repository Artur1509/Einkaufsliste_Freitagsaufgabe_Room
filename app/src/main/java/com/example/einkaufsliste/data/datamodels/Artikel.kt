package com.example.einkaufsliste.data.datamodels

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "artikel_table")

class Artikel(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String
)
