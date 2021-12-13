package dev.juricaplesa.user_data

import dev.juricaplesa.user_domain.UserRepository

const val FIRST_USER_ID = "1"
const val SECOND_USER_ID = "2"

class UserRepositoryImpl : UserRepository {

    private var loggedUserId = FIRST_USER_ID

    override fun getLoggedUserId() = loggedUserId

    override fun switchLoggedUser() {
        loggedUserId = if (loggedUserId == FIRST_USER_ID) {
            SECOND_USER_ID
        } else {
            FIRST_USER_ID
        }
    }

}