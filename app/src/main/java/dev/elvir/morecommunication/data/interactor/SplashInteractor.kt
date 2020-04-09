package dev.elvir.morecommunication.data.interactor

import dev.elvir.morecommunication.data.entity.user.AuthEntity
import io.reactivex.Single

interface SplashInteractor {

    fun getAuthEntity(): Single<AuthEntity>
}