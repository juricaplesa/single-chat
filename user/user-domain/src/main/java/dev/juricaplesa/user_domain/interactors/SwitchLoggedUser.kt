package dev.juricaplesa.user_domain.interactors

import dev.juricaplesa.user_domain.UserRepository

class SwitchLoggedUser(
    private val repository: UserRepository
) {

    fun execute() {
        return repository.switchLoggedUser()
    }

}