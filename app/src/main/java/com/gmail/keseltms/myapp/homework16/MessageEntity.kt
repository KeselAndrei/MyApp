package com.gmail.keseltms.myapp.homework16

import androidx.room.Entity

@Entity(tableName = "table_message", primaryKeys = ["time"])
data class MessageEntity(
    val message: String,
    val time: String
)