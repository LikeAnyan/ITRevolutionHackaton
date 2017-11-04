package com.devguys.itrevolutionhackaton.util;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Toast;

import com.devguys.itrevolutionhackaton.ITRevolutionApp;

/**
 * Created by sergeyboy on 04.11.17.
 */

public class UiUtills {
    private UiUtills(){}

    public static void showToast(final String message){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(() -> Toast.makeText(ITRevolutionApp.get().getApplicationContext(), message, Toast.LENGTH_SHORT).show());
    }

    public static void showToast(@StringRes final int stringRes){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(() -> Toast.makeText(ITRevolutionApp.get().getApplicationContext(), stringRes, Toast.LENGTH_SHORT).show());
    }

    public static void hide(View view)
    {
        view.setVisibility(View.GONE);
    }

    public static void hide(View... views)
    {
        for (final View v : views)
            v.setVisibility(View.GONE);
    }

    public static void invisible(View view)
    {
        view.setVisibility(View.INVISIBLE);
    }

    public static void invisible(View... views)
    {
        for (final View v : views)
            v.setVisibility(View.INVISIBLE);
    }

    public static void show(View view)
    {
        view.setVisibility(View.VISIBLE);
    }

    public static void show(View... views)
    {
        for (final View v : views)
            v.setVisibility(View.VISIBLE);
    }


}
