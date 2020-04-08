package dev.elvir.morecommunication.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface AuthDao {

    @Insert()
    fun addAuth(authEntity: AuthEntity): Single<Long>

    @Query("Select * from authentity where id = :id")
    fun getAuthEntity(id : Int = 0): Single<AuthEntity>

}