package dev.elvir.morecommunication.data.repository

import android.content.SharedPreferences
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

    override fun addAuthEntity(authEntity: AuthEntity): Completable  {
      return authDao.addAuth(authEntity)
            .flatMap {
                it
                Single.fromCallable {
                    sharedPreferences.edit().putLong(ID_AUTH_KEY, it).commit()
                }
            }
          .toCompletable()
    }

    override fun getAuthEntity(): Single<AuthEntity> = authDao.getAuthEntity(0)

}