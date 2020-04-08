package dev.elvir.morecommunication.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dev.elvir.morecommunication.data.db.MoreDB
import dev.elvir.morecommunication.data.db.dao.AuthDao
import dev.elvir.morecommunication.data.db.dao.UserDao
import dev.elvir.morecommunication.di.component.AppScope

@Module
class RoomModule(application: Application) {

    private val moreDB: MoreDB

    init {
        moreDB = Room.databaseBuilder(application, MoreDB::class.java, "more-db").build()
    }

    @AppScope
    @Provides
    fun providesRoomDatabase(): MoreDB {
        return moreDB
    }

    @AppScope
    @Provides
    fun providesUserDao(moreDB: MoreDB): UserDao {
        return moreDB.userDao()
    }

    @AppScope
    @Provides
    fun providesAuthDao(moreDB: MoreDB): AuthDao {
        return moreDB.authDao()
    }

}