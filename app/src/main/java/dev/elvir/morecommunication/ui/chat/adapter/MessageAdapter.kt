package dev.elvir.morecommunication.ui.chat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.elvir.morecommunication.R
import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.data.entity.chat.Message
import dev.elvir.morecommunication.data.entity.chat.MessageType
import dev.elvir.morecommunication.ext.autoNotify
import kotlin.properties.Delegates

class MessageAdapter(
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_MESSAGE_INCOMING = 1
    private val VIEW_TYPE_MESSAGE_OUTCOMING = 2

    var listMessage: List<Message> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.msgUid == n.msgUid }
    }

    override fun getItemViewType(position: Int): Int {
        return when (listMessage[position].messageType) {
            MessageType.INCOMING -> {
                VIEW_TYPE_MESSAGE_INCOMING
            }
            MessageType.OUTCOMING -> {
                VIEW_TYPE_MESSAGE_OUTCOMING
            }
            else -> throw RuntimeException("Message view type not found")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View
        return when (viewType) {
            VIEW_TYPE_MESSAGE_INCOMING -> {
                IncomingMessageViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item_incoming_massage, parent, false)
                )
            }
            VIEW_TYPE_MESSAGE_OUTCOMING -> {
                OutcomingMessageViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.list_item_outcoming_massage, parent, false)
                )
            }
            else -> throw  RuntimeException("Message view holder type not found")

        }
    }

    override fun getItemCount(): Int = listMessage.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var message = listMessage[position]
        when (holder.itemViewType) {
            VIEW_TYPE_MESSAGE_INCOMING -> {
                (holder as IncomingMessageViewHolder).bind(message)
            }
            VIEW_TYPE_MESSAGE_OUTCOMING -> {
                (holder as OutcomingMessageViewHolder).bind(message)
            }
        }
    }

}