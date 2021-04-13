package com.example.helloworld;

import android.graphics.Bitmap;

public class BitmapHelper {
    private Bitmap bitmap = null;
    private static  final BitmapHelper instance = new BitmapHelper();

    public BitmapHelper() {

    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public static BitmapHelper getInstance() {
        return instance;
    }
}
