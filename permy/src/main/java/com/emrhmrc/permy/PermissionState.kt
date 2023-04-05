package com.emrhmrc.permy

sealed class PermissionState {
    object Granted : PermissionState()
    object Denied : PermissionState()
    object PermanentlyDenied : PermissionState()
}

fun PermissionState.onGranted(callback: () -> Unit) = apply {
    if (this == PermissionState.Granted) {
        callback()
    }
}

fun PermissionState.onDenied(callback: () -> Unit) = apply {
    if (this == PermissionState.Denied) {
        callback()
    }
}

fun PermissionState.onPermanentlyDenied(callback: () -> Unit) = apply {
    if (this == PermissionState.PermanentlyDenied) {
        callback()
    }
}

fun PermissionState.onDeniedOrPermanentlyDenied(callback: () -> Unit) = apply {
    if (this == PermissionState.Denied || this == PermissionState.PermanentlyDenied) {
        callback()
    }
}
