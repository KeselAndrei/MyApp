package com.gmail.keseltms.myapp.homework16

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.keseltms.myapp.R
import com.gmail.keseltms.myapp.databinding.ActivityMessengerBinding
import com.gmail.keseltms.myapp.homework13.MySuperApp
import java.util.*

class MessengerActivity : AppCompatActivity() {
    private val messageViewModel: MessageViewModel by viewModels {
        MessageViewModel.MessengerViewModelFactory((application as MySuperApp).messageDao)
    }
    private lateinit var binding: ActivityMessengerBinding

    @SuppressLint("SimpleDateFormat", "UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMessengerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnAddMessage.setOnClickListener {

            val text = binding.editMessage.text
            val timeMillis = System.currentTimeMillis()
            val date = Date(timeMillis)
            val format = SimpleDateFormat("dd.M.yyyy HH:mm:ss")
            messageViewModel.addMessageToDatabase(text.toString(), format.format(date))
            binding.editMessage.text = null
        }

        val messageAdapter = MessageAdapter(::messageClickListener)

        with(binding.rvMessageInfo) {
            layoutManager = LinearLayoutManager(
                this@MessengerActivity, LinearLayoutManager.VERTICAL, false
            )
            adapter = messageAdapter

            addItemDecoration((DividerItemDecoration(context, LinearLayoutManager.VERTICAL)).apply {
                getDrawable(R.drawable.my_drawable)?.let { setDrawable(it) }
            })
        }

        messageViewModel.liveData.observe(this, {
            messageAdapter.update(it)
        })
    }

    private fun messageClickListener(message: Message) {

        messageViewModel.deleteMessageFromDatabase(message)
    }
}