package dev.elvir.morecommunication.data.repository

import android.content.SharedPreferences
import dev.elvir.morecommunication.data.db.dao.UserDao
import dev.elvir.morecommunication.data.entity.user.UserEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

const val UID_PREFS_KEY = "uid_prefs_key"

class CurrentUserRepositoryImpl @Inject constructor(
    val sharedPreferences: SharedPreferences,
    var userDao: UserDao
) : CurrentUserRepository {

    override fun addUid(uid: Long) = sharedPreferences.edit().putLong(UID_PREFS_KEY, uid).apply()

    override fun getUid(): Long = sharedPreferences.getLong(UID_PREFS_KEY, 0)

    override fun addUser(userEntity: UserEntity): Completable = userDao.addUser(userEntity)

    override fun getUser(): Single<UserEntity> = userDao.getUserByUid(getUid())

    override fun save(uid: Long)  = sharedPreferences.edit().putLong("a", uid).apply()

    override fun gets(): Long = sharedPreferences.getLong("a", 0)

}