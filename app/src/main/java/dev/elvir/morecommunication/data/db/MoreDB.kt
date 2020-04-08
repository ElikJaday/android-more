package dev.elvir.morecommunication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import dev.elvir.morecommunication.data.db.dao.AuthDao
import dev.elvir.morecommunication.data.db.dao.UserDao
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import dev.elvir.morecommunication.data.entity.user.AuthStateConverter
import dev.elvir.morecommunication.data.entity.user.UserEntity

@Database(
    entities = [
        UserEntity::class,
        AuthEntity::class
    ],
    version = 1
)
@TypeConverters(AuthStateConverter::class)
abstract class MoreDB : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun authDao(): AuthDao

}