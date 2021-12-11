package dev.juricaplesa.core.model

sealed class ProgressState {

    object Idle: ProgressState()
    object Loading: ProgressState()

}
