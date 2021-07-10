package com.gmail.keseltms.myapp.homework16

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MessageViewModel(
    private val messageDao: MessageDao
) : ViewModel() {

    val liveData: LiveData<List<Message>> = messageDao.getMessageList().map {
        it.map { messageEntity ->
            Message(messageEntity.message, messageEntity.time)
        }
    }.asLiveData()

    fun addMessageToDatabase(text: String, time: String) {
        val message = MessageEntity(
            text,
            time
        )
        viewModelScope.launch(Dispatchers.IO) {
            messageDao.addMessage(message)
        }
    }

    fun deleteMessageFromDatabase(message: Message) {
        viewModelScope.launch(Dispatchers.IO) {
            messageDao.deleteMessage(MessageEntity(message.message, message.time))
        }
    }

    class MessengerViewModelFactory(
        private val messageDao: MessageDao
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MessageViewModel(messageDao) as T
        }
    }
}