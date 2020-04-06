package dev.elvir.morecommunication.data.repository

import android.content.SharedPreferences

const val UID_PREFS_KEY = "uid_prefs_key"

class UserRepositoryImpl(
    val sharedPreferences: SharedPreferences
) : UserRepository {

    override fun addUid(uid: Long) = sharedPreferences.edit().putLong(UID_PREFS_KEY, uid).apply()

    override fun getUid(): Long = sharedPreferences.getLong(UID_PREFS_KEY,0)

}