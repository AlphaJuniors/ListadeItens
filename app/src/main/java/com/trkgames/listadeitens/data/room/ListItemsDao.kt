package com.trkgames.listadeitens.data.room

import androidx.room.*
import com.trkgames.listadeitens.constants.COLUMN_ID
import com.trkgames.listadeitens.constants.COLUMN_NAME_ITEM
import com.trkgames.listadeitens.constants.TABLE_LIST
import com.trkgames.listadeitens.data.room.model.Item

@Dao
interface ListItemsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: Item): Long

    @Update
    fun update(item: Item): Long

    @Delete
    fun delete(vararg items: Item): Long

    @Query("SELECT * FROM $TABLE_LIST WHERE $COLUMN_ID = :id")
    fun listItemById(id: Long): Item

    @Query("SELECT * FROM $TABLE_LIST WHERE $COLUMN_NAME_ITEM LIKE :term ORDER BY $COLUMN_NAME_ITEM")
    fun search(term: String): List<Item>
}