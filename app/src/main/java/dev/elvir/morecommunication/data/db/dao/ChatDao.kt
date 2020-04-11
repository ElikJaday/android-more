package dev.elvir.morecommunication.data.db.dao

import androidx.room.*
import dev.elvir.morecommunication.data.entity.chat.Chat
import io.reactivex.Flowable
import java.lang.Exception


@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insert(chat: Chat): Long

    @Update(onConflict = OnConflictStrategy.FAIL)
    fun update(chat: Chat): Int

    @Query("select * from chat")
    fun getAll(): Flowable<MutableList<Chat>>

    fun upsert(chat: Chat) {
        try {
            insert(chat)
        }catch (e : Exception){
            update(chat)
        }
    }
}