package com.devguys.itrevolutionhackaton.util.permission;

/**
 * Created by sergeyboy on 04.11.17.
 */

public class PermissionsResult {
    private final boolean mExternalStorageGranted;
    private final boolean mCameraGranted;

    public PermissionsResult(boolean mExternalStorageGranted, boolean mCameraGranted) {
        this.mExternalStorageGranted = mExternalStorageGranted;
        this.mCameraGranted = mCameraGranted;
    }

    public boolean isExternalStorageGranted(){
        return mExternalStorageGranted;
    }

    public boolean isCameraGranted(){
        return mCameraGranted;
    }

    public boolean isAllPermissionsGranted(){
        return mExternalStorageGranted && mCameraGranted;
    }
}
