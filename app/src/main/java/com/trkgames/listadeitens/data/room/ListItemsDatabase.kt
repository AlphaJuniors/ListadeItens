package com.trkgames.listadeitens.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.trkgames.listadeitens.constants.DATABASE_NAME
import com.trkgames.listadeitens.constants.DATABASE_VERSION
import com.trkgames.listadeitens.data.room.model.Item

@Database(entities = [Item::class], version = DATABASE_VERSION)
abstract class ListItemsDatabase : RoomDatabase() {

    abstract fun listItemDao(): ListItemsDao

    companion object {
        private var instance: ListItemsDatabase? = null

        fun getDatabase(context: Context): ListItemsDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ListItemsDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .build()
            }

            return instance as ListItemsDatabase
        }

        fun destroyInstance(){
            instance = null
        }
    }
}