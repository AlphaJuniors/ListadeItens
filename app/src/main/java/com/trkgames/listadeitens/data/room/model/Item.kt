package com.trkgames.listadeitens.data.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.trkgames.listadeitens.constants.*

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ID)
    val id: Long = 0,
    @ColumnInfo(name = COLUMN_NAME_ITEM)
    val nameItem: String,
    @ColumnInfo(name = COLUMN_DESCRIPTION)
    val description: String = "",
    @ColumnInfo(name =  COLUMN_PRICE)
    val price: Double = 0.0,
    @ColumnInfo(name = COLUMN_CATEGORY)
    val category: String
)
