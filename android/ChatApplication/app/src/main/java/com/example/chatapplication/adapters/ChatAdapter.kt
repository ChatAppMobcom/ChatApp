package com.example.chatapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapplication.R
import com.example.chatapplication.models.Chat

class ChatAdapter(private val chats: List<Chat>, var token: String) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {
    var chatSender: Int = 0
    var chatReceiver: Int = 1

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemNama: TextView
        val itemChat: TextView
        val itemWaktu: TextView

        init {
            itemNama = itemView.findViewById(R.id.nama)
            itemChat = itemView.findViewById(R.id.chat)
            itemWaktu = itemView.findViewById(R.id.waktu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if (viewType == chatSender) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_chat_sender, parent, false)
            return ViewHolder(view)
        }
        else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.row_chat, parent, false)
            return ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemNama.text = chats[position].nama
        holder.itemChat.text = chats[position].chat
        holder.itemWaktu.text = chats[position].waktu
    }

    override fun getItemCount() = chats.size

    override fun getItemViewType(position: Int): Int {
        // ga dapet token
        if (chats[position].token.equals(token)) {
            return chatSender
        }
        else {
            return chatReceiver
        }
    }
}