package ru0xdc;

import android.graphics.Bitmap;

/**
 * Blur using the NDK and native code.
 * from https://github.com/kikoso/android-stackblur/
 */
public class NdkStackBlur {

    private final int mNumThreads;

    static {
        System.loadLibrary("stackblur");
    }

    public NdkStackBlur(int numThreads) {
        mNumThreads = numThreads;
    }

    public static NdkStackBlur create() {
        return createMultithreaded();
    }

    public static NdkStackBlur createMultithreaded() {
        return new NdkStackBlur(Runtime.getRuntime().availableProcessors());
    }

    private static native void functionToBlur(Bitmap bitmapOut, int radius, int threadCount);

    public Bitmap blur(int radius, Bitmap bitmap) {
        functionToBlur(bitmap, radius, mNumThreads);
        return bitmap;
    }
}
