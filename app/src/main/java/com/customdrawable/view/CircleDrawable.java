package com.customdrawable.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018/3/20.
 */

public class CircleDrawable extends Drawable {
    private Paint paint;
    private Bitmap bitmap;
    private int size;
    private float cx,cy,radius;

    public CircleDrawable(Bitmap bitmap) {
        this.bitmap = bitmap;

        BitmapShader bitmapShader=new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        size=Math.min(bitmap.getWidth(),bitmap.getHeight());
        cx=size/2;
        cy=size/2;
        radius=size/2;
    }


    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(cx,cy,radius,paint);
    }

    @Override
    public void setAlpha(int i) {
        paint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public int getIntrinsicHeight() {
        return size;
    }

    @Override
    public int getIntrinsicWidth() {
        return size;
    }
}
