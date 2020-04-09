package dev.elvir.morecommunication.data.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import dev.elvir.morecommunication.data.db.dao.AuthDao
import dev.elvir.morecommunication.data.entity.user.AuthEntity
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

const val ID_AUTH_KEY = "id_auth_key"


interface AuthRepository {

    fun addAuthEntity(authEntity: AuthEntity): Completable
    fun getAuthEntity(): Single<AuthEntity>

}

class AuthRepositoryImpl @Inject constructor(
    val sharedPreferences: SharedPreferences,
    val authDao: AuthDao
) : AuthRepository {

    override fun addAuthEntity(authEntity: AuthEntity): Completable {
        val json = Gson().toJson(authEntity)
        sharedPreferences.edit().putString(ID_AUTH_KEY, json).apply()
        return Completable.complete()
    }


    override fun getAuthEntity(): Single<AuthEntity> =
        Single.fromCallable {
            val json = sharedPreferences.getString(ID_AUTH_KEY, "")
            Gson().fromJson(json, AuthEntity::class.java)
        }

}