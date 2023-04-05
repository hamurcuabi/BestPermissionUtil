package com.example.bestpermissionutil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emrhmrc.permy.PermissionState
import com.emrhmrc.permy.onDenied
import com.emrhmrc.permy.onGranted
import com.emrhmrc.permy.onPermanentlyDenied
import com.emrhmrc.permy.registerPermission

class MainActivity : AppCompatActivity() {

    private val cameraPermission = registerPermission {
        onCameraPermissionResult(it)
    }

    private val storagePermission = registerPermission {
        onStoragePermissionResult(it)
    }

    private fun onStoragePermissionResult(state: PermissionState) {
        state.onGranted {

        }.onDenied {

        }.onPermanentlyDenied {

        }
    }

    private fun onCameraPermissionResult(state: PermissionState) {
        state.onGranted {

        }.onDenied {

        }.onPermanentlyDenied {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameraPermission.launch(android.Manifest.permission.CAMERA)

        storagePermission.launch(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }
}