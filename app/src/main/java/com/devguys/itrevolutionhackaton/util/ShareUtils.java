package com.devguys.itrevolutionhackaton.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;

public class ShareUtils {

    public static SharePhotoContent shareToFB(Bitmap image) {
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .build();
        return new SharePhotoContent.Builder().addPhoto(photo).build();
    }

    public static Bitmap loadBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable = view.getBackground();

        if (bgDrawable != null)
            bgDrawable.draw(canvas);
        else canvas.drawColor(Color.WHITE);

        view.draw(canvas);
        return returnedBitmap;
    }
}
