package dev.juricaplesa.core

import dev.juricaplesa.core.model.ProgressState
import java.lang.Exception

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    data class Progress<out T>(val progressState: ProgressState = ProgressState.Idle): Result<T>()

}
