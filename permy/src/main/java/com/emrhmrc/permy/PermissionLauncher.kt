package com.emrhmrc.permy

import androidx.activity.result.ActivityResultLauncher

@JvmInline
value class PermissionLauncher(val result: ActivityResultLauncher<Array<String>>) {

    fun launch(vararg permissions: String) {
        val finalList = permissions.toList().toTypedArray()
        result.launch(finalList)
    }
}
