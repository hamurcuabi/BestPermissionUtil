package com.emrhmrc.permy

import android.app.Activity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.fragment.app.Fragment

object PermissionUtil {

    @JvmInline
    value class Permission(val result: ActivityResultLauncher<Array<String>>)

    sealed class PermissionState {
        object Granted : PermissionState()
        object Denied : PermissionState()
        object PermanentlyDenied : PermissionState()
    }

    private fun getPermissionState(activity: Activity, result: Map<String, Boolean>): PermissionState {
    val deniedPermissions = result.filterValues { !it }.keys

    return when {
        deniedPermissions.isEmpty() -> PermissionState.Granted
        deniedPermissions.any { permission ->
            !shouldShowRequestPermissionRationale(
                /* activity = */
                activity,
                /* permission = */
                permission
            )
        } -> PermissionState.PermanentlyDenied

        else -> PermissionState.Denied
    }
}

    fun Fragment.registerPermission(onPermissionResult: (PermissionState) -> Unit): Permission {
        return Permission(
            this.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                onPermissionResult(getPermissionState(activity, it))
            }
        )
    }

    fun AppCompatActivity.registerPermission(onPermissionResult: (PermissionState) -> Unit): Permission {
        return Permission(
            this.registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
                onPermissionResult(getPermissionState(this, it))
            }
        )
    }

    fun Permission.launchSinglePermission(permission: String) {
        this.result.launch(arrayOf(permission))
    }

    fun Permission.launchMultiplePermission(permissionList: Array<String>) {
        this.result.launch(permissionList)
    }
}
