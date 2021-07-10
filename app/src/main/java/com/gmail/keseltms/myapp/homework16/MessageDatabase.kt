package com.gmail.keseltms.myapp.homework16

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MessageEntity::class], version = 1)
abstract class MessageDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}