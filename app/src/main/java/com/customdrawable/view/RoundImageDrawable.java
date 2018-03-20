package com.customdrawable.view;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * 圆角图片
 * Created by zh on 2018/3/20.
 */

public class RoundImageDrawable extends Drawable {
    private Paint mpaint;
    private Bitmap bitmap;
    private RectF rectF;
    private float radius;


    public RoundImageDrawable(Bitmap bitmap,float radius) {
        this.radius=radius;
        this.bitmap = bitmap;
//        CLAMP 拉伸 （设置matrix）
//        REPEAT 重复  横向、纵向不断重复这个bitmap
//        MIRROR 镜像
        BitmapShader bitmapShader=new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mpaint=new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(bitmapShader);
    }


    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        rectF=new RectF(left,top,right,bottom);

    }



    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(rectF,radius,radius,mpaint);
    }

    @Override
    public int getIntrinsicWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getIntrinsicHeight() {
        return bitmap.getHeight();
    }

    @Override
    public void setAlpha(int i) {
        mpaint.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mpaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
