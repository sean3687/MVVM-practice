package com.tassiecomp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabaseDao : RoomDatabase() {
    abstract fun TodoDao(): TodoDao
}