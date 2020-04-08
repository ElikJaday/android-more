package dev.elvir.morecommunication.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.elvir.morecommunication.data.entity.user.UserEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    fun addUser(userEntity: UserEntity) : Completable

    @Query("Select * from userentity where uid = :uid")
    fun getUserByUid(uid: Long ): Single<UserEntity>

}