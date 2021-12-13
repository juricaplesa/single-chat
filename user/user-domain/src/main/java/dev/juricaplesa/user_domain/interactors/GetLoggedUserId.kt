package dev.juricaplesa.user_domain.interactors

import dev.juricaplesa.user_domain.UserRepository

class GetLoggedUserId(
    private val repository: UserRepository
) {

    fun execute(): String {
        return repository.getLoggedUserId()
    }

}