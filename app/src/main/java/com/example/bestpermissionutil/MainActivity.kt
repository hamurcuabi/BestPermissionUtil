package com.example.bestpermissionutil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emrhmrc.permy.PermissionUtil
import com.emrhmrc.permy.PermissionUtil.PermissionState.*
import com.emrhmrc.permy.PermissionUtil.launchMultiplePermission
import com.emrhmrc.permy.PermissionUtil.launchSinglePermission
import com.emrhmrc.permy.PermissionUtil.registerPermission

class MainActivity : AppCompatActivity() {

    private val cameraPermission = registerPermission {
        onCameraPermissionResult(it)
    }

    private val storagePermission = registerPermission {
        onStoragePermissionResult(it)
    }

    private fun onStoragePermissionResult(state: PermissionUtil.PermissionState) {
        when (state) {
            Denied -> {
                TODO()
            }
            Granted -> {
                TODO()
            }
            PermanentlyDenied -> {
                TODO()
            }
        }
    }

    private fun onCameraPermissionResult(state: PermissionUtil.PermissionState) {
        when (state) {
            Denied -> {
                TODO()
            }
            Granted -> {
                TODO()
            }
            PermanentlyDenied -> {
                TODO()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraPermission.launchSinglePermission(android.Manifest.permission.CAMERA)

        storagePermission.launchMultiplePermission(
            arrayOf(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        )
    }
}