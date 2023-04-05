package com.emrhmrc.permy

import android.app.Activity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.fragment.app.Fragment

fun Fragment.registerPermission(callback: (PermissionState) -> Unit): PermissionLauncher =
    PermissionLauncher(
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            callback(getPermissionState(requireActivity(), result))
        }
    )

fun AppCompatActivity.registerPermission(callback: (PermissionState) -> Unit): PermissionLauncher =
    PermissionLauncher(
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            callback(getPermissionState(this, result))
        }
    )

private fun getPermissionState(activity: Activity, result: Map<String, Boolean>): PermissionState {
    val deniedPermissions = result.filterValues { !it }.keys

    return when {
        deniedPermissions.isEmpty() -> PermissionState.Granted
        deniedPermissions.any { permission ->
            !shouldShowRequestPermissionRationale(
                activity,
                permission
            )
        } -> PermissionState.PermanentlyDenied

        else -> PermissionState.Denied
    }
}
