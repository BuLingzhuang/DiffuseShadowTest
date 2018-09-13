package com.intsig.scanner.diffuseshadowtest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class Test {

    //羽化
    public static Bitmap feather(Bitmap bitmap) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Bitmap result = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        int ratio = w > h ? h * 32768 / w : w * 32768 / h;
        int r, g, b, color;
        int[] oldPx = new int[w * h];
        int[] newPx = new int[w * h];
        float Size = 0.5f;
        int cx = w >> 1;
        int cy = h >> 1;
        int max = cx * cx + cy * cy;
        int min = (int) (max * (1 - Size));
        int diff = max - min;
        bitmap.getPixels(oldPx, 0, w, 0, 0, w, h);
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                color = oldPx[x * h + y];
                r = Color.red(color);
                g = Color.green(color);
                b = Color.blue(color);
                int dx = cx - x;
                int dy = cy - y;
                if (w > h) {
                    dx = (dx * ratio) >> 15;
                } else {
                    dy = (dy * ratio) >> 15;
                }
                int distSq = dx * dx + dy * dy;
                float v = ((float) distSq / diff) * 255;
                r = (int) (r + (v));
                g = (int) (g + (v));
                b = (int) (b + (v)); //检查各点像素值是否超出范围
                r = (r > 255 ? 255 : (r < 0 ? 0 : r));
                g = (g > 255 ? 255 : (g < 0 ? 0 : g));
                b = (b > 255 ? 255 : (b < 0 ? 0 : b));
                newPx[x * h + y] = Color.rgb(r, g, b);
            }
        }
        result.setPixels(newPx, 0, w, 0, 0, w, h);
        return result;
    }
}