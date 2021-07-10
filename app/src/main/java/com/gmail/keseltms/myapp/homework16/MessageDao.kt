package com.gmail.keseltms.myapp.homework16

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDao {

    @Query("SELECT * FROM table_message")
    fun getMessageList(): Flow<List<MessageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMessage(message: MessageEntity)

    @Delete
    suspend fun deleteMessage(message: MessageEntity)
}