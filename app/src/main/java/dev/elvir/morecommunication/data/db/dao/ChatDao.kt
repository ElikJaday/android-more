package dev.elvir.morecommunication.data.db.dao

import androidx.room.*
import dev.elvir.morecommunication.data.entity.chat.Chat
import dev.elvir.morecommunication.data.entity.chat.Message
import io.reactivex.Flowable


@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertChat(chat: Chat): Long

    @Update(onConflict = OnConflictStrategy.FAIL)
    fun updateChat(chat: Chat): Int

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertMsg(message: Message): Long

    @Update(onConflict = OnConflictStrategy.FAIL)
    fun updateMsg(message: Message): Int

    @Query("select * from Message m where m.chatLinkId = :chatId order by m.clientTime desc")
    fun getAllMsg(chatId: Long): Flowable<MutableList<Message>>

    @Query("select * from chat")
    fun getAll(): Flowable<MutableList<Chat>>

    fun upsertChat(chat: Chat) {
        try {
            insertChat(chat)
        } catch (e: Exception) {
            updateChat(chat)
        }
    }

    fun upsertMessage(message: Message) {
        try {
           val a =insertMsg(message)
             a
        } catch (e: Exception) {
           val b =  updateMsg(message)
            b
        }
    }
}