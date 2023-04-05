# BestPermissionUtil

You can read the story from here https://hamurcuabi.medium.com/permissions-with-the-easiest-way-9c466ab1b2c1


## Prerequisites

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

## Dependency

![](https://jitpack.io/v/hamurcuabi/BestPermissionUtil.svg)

Add this to your module's `build.gradle` file (make sure the version matches the JitPack badge above):

```gradle
dependencies {
	...
	 implementation 'com.github.hamurcuabi:BestPermissionUtil:1.1.0'
}
```

## Usage

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
    
     cameraPermission.launch(android.Manifest.permission.CAMERA)

        storagePermission.launch(
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
