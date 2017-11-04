package com.devguys.itrevolutionhackaton.util.permission;

/**
 * Created by sergeyboy on 04.11.17.
 */

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.devguys.itrevolutionhackaton.ITRevolutionApp;

import java.util.HashMap;
import java.util.Map;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.CAMERA;

public class PermissionUtills {
    private static final String[] PERMISSIONS_PHOTO = new String[] {
            WRITE_EXTERNAL_STORAGE,
            CAMERA
    };

    private PermissionUtills() {}

    public static boolean isPermissionsPhotoGranted(){
        PermissionsResult permissionsResult = checkPermissions();
        return permissionsResult.isAllPermissionsGranted();
    }

    public static void requestPermissionsPhoto(@NonNull Activity activity, int code){
        ActivityCompat.requestPermissions(activity, PERMISSIONS_PHOTO, code);
    }

    @NonNull
    private static PermissionsResult checkPermissions()
    {
        Context context = ITRevolutionApp.get().getApplicationContext();
        Map<String, Boolean> result = new HashMap<>();
        for (String permission: PERMISSIONS_PHOTO)
        {
            result.put(permission,
                    Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                            || context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
        }

        return getPermissionsResult(result);
    }

    @NonNull
    private static PermissionsResult getPermissionsResult(@NonNull Map<String, Boolean> result)
    {
        boolean externalStorageGranted = result.containsKey(WRITE_EXTERNAL_STORAGE)
                ? result.get(WRITE_EXTERNAL_STORAGE) : false;
        boolean cameraGranted = (result.containsKey(CAMERA)
                ? result.get(CAMERA) : false);
        return new PermissionsResult(externalStorageGranted, cameraGranted);
    }
}
