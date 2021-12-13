package dev.juricaplesa.user_domain

interface UserRepository {

    /**
     * Returns currently logged user id
     */
    fun getLoggedUserId(): String

    /**
     * Switches currently logged users
     */
    fun switchLoggedUser()

}