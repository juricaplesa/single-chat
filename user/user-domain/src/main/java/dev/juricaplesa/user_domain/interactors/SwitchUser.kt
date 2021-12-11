package dev.juricaplesa.user_domain.interactors

import dev.juricaplesa.user_data.UserRepository

class SwitchUser(
    private val repository: UserRepository
) {

    fun execute() {
        return repository.toggleLoggedUser()
    }

}