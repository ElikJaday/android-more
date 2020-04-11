package dev.elvir.morecommunication.data.interactor

import dev.elvir.morecommunication.data.entity.user.AuthEntity
import dev.elvir.morecommunication.data.repository.AuthRepository
import io.reactivex.Single
import javax.inject.Inject

interface SplashInteractor {

    fun getAuthEntity(): Single<AuthEntity>
}

class SplashInteractorImpl @Inject constructor(
    private val authRepository: AuthRepository
) : SplashInteractor {

    override fun getAuthEntity(): Single<AuthEntity> = authRepository.getAuthEntity()

}