package dev.elvir.morecommunication.data.interactor

import dev.elvir.morecommunication.data.repository.CurrentUserRepository
import javax.inject.Inject

interface SignInModeInteractor {

}

class SignInModeInteractorImpl @Inject constructor(
    currentUserRepository: CurrentUserRepository
) : SignInModeInteractor {


}