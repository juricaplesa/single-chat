package dev.juricaplesa.user_data

const val FIRST_USER_ID = 1
const val SECOND_USER_ID = 2

class UserRepository {

    var loggedUserId = FIRST_USER_ID

    fun toggleLoggedUser() {
        loggedUserId = if (loggedUserId == FIRST_USER_ID) {
            SECOND_USER_ID
        } else {
            FIRST_USER_ID
        }
    }

}